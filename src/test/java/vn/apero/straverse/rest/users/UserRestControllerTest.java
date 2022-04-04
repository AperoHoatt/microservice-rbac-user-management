package vn.apero.straverse.rest.users;

import vn.apero.straverse.rest.users.dtos.AddressDTO;
import vn.apero.straverse.rest.users.dtos.ContactDTO;
import vn.apero.straverse.rest.users.dtos.UserDTO;
import vn.apero.straverse.rest.users.dtos.requests.CreateOrUpdateUserDTO;
import vn.apero.straverse.rest.users.dtos.requests.RegisterUserAccountDTO;
import vn.apero.straverse.rest.users.entities.User;
import vn.apero.straverse.rest.users.repositories.UserRepository;
import vn.apero.straverse.rest.users.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRestControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void test_getUserById() {
        Long userId = 1L;
        String userURL = "/users/" + userId;

        ResponseEntity<UserDTO> response = restTemplate.getForEntity(userURL, UserDTO.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

        UserDTO userDTO = response.getBody();
        assertNotNull(userDTO);

        assertThat(userDTO.getId(), equalTo(1L));
        assertThat(userDTO.getName(), equalTo("Andrea"));
        assertThat(userDTO.getSurname(), equalTo("Test"));
        assertThat(userDTO.getContactDTO().getEmail(), equalTo("andrea.test@gmail.com"));
        assertThat(userDTO.isEnabled(), equalTo(true));
    }

    @Test
    public void test_createUser() {
        CreateOrUpdateUserDTO createOrUpdateUserDTO = new CreateOrUpdateUserDTO.Builder()
                .setUsername("frank")
                .setPassword("Frank!123")
                .setName("Frank")
                .setSurname("Blu")
                .setGender("MALE")
                .setEnabled(true)
                .setNote("created for test")
                .setEmail("frank.blu@gmail.com")
                .setPhone("+3531194334455")
                .setSkype("skype")
                .setFacebook("facebook")
                .setLinkedin("linkedin")
                .setWebsite("www.test.com")
                .setContactNote("Test on contact")
                .setAddress("dark road 1")
                .setAddress2("salt hill")
                .setCity("Dublin")
                .setCountry("Ireland")
                .setZipCode("47335")
                .build();

        URI uri = URI.create("/users");

        HttpEntity<CreateOrUpdateUserDTO> request = new HttpEntity<>(createOrUpdateUserDTO);
        ResponseEntity<UserDTO> response = restTemplate.postForEntity(uri, request, UserDTO.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));

        UserDTO userDTO = response.getBody();
        assertNotNull(userDTO);

        assertNotNull(userDTO);
        assertEquals("frank", userDTO.getUsername());
        assertEquals("Frank", userDTO.getName());
        assertEquals("Blu", userDTO.getSurname());
        assertEquals("MALE", userDTO.getGender());

        assertEquals(true, userDTO.isEnabled());
        assertEquals("created for test", userDTO.getNote());

        ContactDTO contactDTO = userDTO.getContactDTO();

        assertEquals("frank.blu@gmail.com", contactDTO.getEmail());
        assertEquals("+3531194334455", contactDTO.getPhone());
        assertEquals("skype", contactDTO.getSkype());
        assertEquals("facebook", contactDTO.getFacebook());
        assertEquals("linkedin", contactDTO.getLinkedin());
        assertEquals("www.test.com", contactDTO.getWebsite());
        assertEquals("Test on contact", contactDTO.getContactNote());

        assertNotNull(userDTO.getAddressDTO());
        AddressDTO addressDTO = userDTO.getAddressDTO();
        assertEquals("dark road 1", addressDTO.getAddress());
        assertEquals("salt hill", addressDTO.getAddress2());
        assertEquals("Dublin", addressDTO.getCity());
        assertEquals("Ireland", addressDTO.getCountry());
        assertEquals("47335", addressDTO.getZipCode());

        // delete the created user
        userService.deleteUserById(userDTO.getId());
    }

    @Test
    public void test_updateUser() {
        // create a new user to update
        RegisterUserAccountDTO quickAccount = new RegisterUserAccountDTO.Builder()
                .setUsername("anna")
                .setPassword("Anna!123")
                .setName("Anna")
                .setSurname("Verdi")
                .setGender("FEMALE")
                .setEmail("anna.verdi@gmail.com")
                .build();

        String registerAccountURL = "/users/register";
        HttpEntity<RegisterUserAccountDTO> requestCreate = new HttpEntity<>(quickAccount);
        ResponseEntity<UserDTO> responseCreate = restTemplate.postForEntity(registerAccountURL, requestCreate, UserDTO.class);

        assertThat(responseCreate.getStatusCode(), equalTo(HttpStatus.CREATED));
        UserDTO userDTO = responseCreate.getBody();

        assertNotNull(userDTO);

        // test the update
        Long userId = userDTO.getId();
        URI uri = URI.create("/users/" + userId);

        CreateOrUpdateUserDTO createOrUpdateUserDTO = new CreateOrUpdateUserDTO.Builder()
                .setUsername("anna")
                .setPassword("Anna!123456")
                .setName("Anna")
                .setSurname("Verdi")
                .setGender("FEMALE")
                .setEnabled(true)
                .setNote("updated for test")
                .setEmail("anna.verdi@gmail.com")
                .setPhone("+3531194334455")
                .setSkype("skype")
                .setFacebook("facebook")
                .setLinkedin("linkedin")
                .setWebsite("www.test.com")
                .setContactNote("Test on contact")
                .setAddress("The sunny road 15")
                .setAddress2("Sunny valley")
                .setCity("Dublin")
                .setCountry("Ireland")
                .setZipCode("47335")
                .build();

        HttpEntity<CreateOrUpdateUserDTO> request = new HttpEntity<>(createOrUpdateUserDTO);
        ResponseEntity<UserDTO> response = restTemplate.exchange(uri, HttpMethod.PUT, request, UserDTO.class);

        assertThat(response.getStatusCode(), is(HttpStatus.CREATED));

        UserDTO userUpdatedDTO = response.getBody();

        assertEquals("anna", userUpdatedDTO.getUsername());
        assertEquals("Anna", userUpdatedDTO.getName());
        assertEquals("Verdi", userUpdatedDTO.getSurname());
        assertEquals("FEMALE", userUpdatedDTO.getGender());
        assertEquals(true, userUpdatedDTO.isEnabled());

        assertEquals("updated for test", userUpdatedDTO.getNote());

        // contact
        ContactDTO contactDTO = userUpdatedDTO.getContactDTO();
        assertNotNull(contactDTO);

        assertEquals("anna.verdi@gmail.com", contactDTO.getEmail());
        assertEquals("+3531194334455", contactDTO.getPhone());
        assertEquals("skype", contactDTO.getSkype());
        assertEquals("facebook", contactDTO.getFacebook());
        assertEquals("linkedin", contactDTO.getLinkedin());
        assertEquals("www.test.com", contactDTO.getWebsite());
        assertEquals("Test on contact", contactDTO.getContactNote());

        // address
        assertNotNull(userUpdatedDTO.getAddressDTO());
        assertEquals("The sunny road 15", userUpdatedDTO.getAddressDTO().getAddress());
        assertEquals("Sunny valley", userUpdatedDTO.getAddressDTO().getAddress2());
        assertEquals("Dublin", userUpdatedDTO.getAddressDTO().getCity());
        assertEquals("Ireland", userUpdatedDTO.getAddressDTO().getCountry());
        assertEquals("47335", userUpdatedDTO.getAddressDTO().getZipCode());

        // delete the user
        userService.deleteUserById(userUpdatedDTO.getId());
    }

    @Test
    public void test_deleteUser() {
        // create a new user to test the deletion
        RegisterUserAccountDTO quickAccount = new RegisterUserAccountDTO.Builder()
                .setUsername("anna2")
                .setPassword("Anna2!123")
                .setName("Anna2")
                .setSurname("Verdi")
                .setGender("FEMALE")
                .setEmail("anna2.verdi@gmail.com")
                .build();

        String registerAccountURL = "/users/register";
        HttpEntity<RegisterUserAccountDTO> request = new HttpEntity<>(quickAccount);
        ResponseEntity<UserDTO> response = restTemplate.postForEntity(registerAccountURL, request, UserDTO.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));
        UserDTO userDTO = response.getBody();

        assertNotNull(userDTO);

        // call the delete endpoint
        String deleteUserURL = "/users/" + userDTO.getId();
        restTemplate.delete(deleteUserURL);

        // retrieve a not existing user must to be empty response
        Optional<User> userOpt = userRepository.findById(userDTO.getId());
        assertFalse(userOpt.isPresent());
    }

    @Test
    public void test_delete_securedUser_return_BAD_REQUEST() {
        // create a new user to test the deletion
        RegisterUserAccountDTO quickAccount = new RegisterUserAccountDTO.Builder()
                .setUsername("anna2")
                .setPassword("Anna2!123")
                .setName("Anna2")
                .setSurname("Verdi")
                .setGender("FEMALE")
                .setEmail("anna2.verdi@gmail.com")
                .build();

        String registerAccountURL = "/users/register";
        HttpEntity<RegisterUserAccountDTO> request = new HttpEntity<>(quickAccount);
        ResponseEntity<UserDTO> response = restTemplate.postForEntity(registerAccountURL, request, UserDTO.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));
        UserDTO userDTO = response.getBody();

        assertNotNull(userDTO);

        // call the delete endpoint
        String deleteUserURL = "/users/" + userDTO.getId();
        restTemplate.delete(deleteUserURL);

        // retrieve a not existing user must to be empty response
        Optional<User> userOpt = userRepository.findById(userDTO.getId());
        assertFalse(userOpt.isPresent());
    }

}
