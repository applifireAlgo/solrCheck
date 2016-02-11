package proejct4.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import proejct4.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import proejct4.app.server.repository.AddressRepository;
import proejct4.app.shared.location.Address;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import proejct4.app.shared.location.AddressType;
import proejct4.app.server.repository.AddressTypeRepository;
import proejct4.app.shared.location.City;
import proejct4.app.server.repository.CityRepository;
import proejct4.app.shared.location.Country;
import proejct4.app.server.repository.CountryRepository;
import proejct4.app.shared.location.State;
import proejct4.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("jMqmXtnpbq3dV9UJUaNao6PQM41p7JL8hOgDNYsRxzaRCPscLC");
            addresstype.setAddressTypeDesc("cEBj6WdQOWc1SJCIYoDRIbwxdXpYeN4ewI9GEaTrrIVg0YwPKT");
            addresstype.setAddressTypeIcon("6kejz54mG0tHw9GOBp15c8MXqP5Wy2vZ0j2KCjNK5uKyiyDK5w");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("XwnllbA8eoFw7xf8PvPVEL2LWVSInPcN");
            city.setCityDescription("CymLZAXX2BGhDnKz8KOYciuXkBu0t5uYVDHq6FvgMRxKMrj8aw");
            city.setCityFlag("YNBySSScDVvWbxO0GvQHyv9Orrl2mYYnxJ34SgfqJ2LemZQfu0");
            city.setCityLatitude(4);
            city.setCityLongitude(8);
            city.setCityName("xsLQSUDBXhboG7djodtVSaauAbiloJEQLQ4LNgrSA8NuhL71Cu");
            Country country = new Country();
            country.setCapital("LorMPXsRXq70DEeWifIdYojGXyi7SJjf");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(11);
            country.setCountryCode1("TbU");
            country.setCountryCode2("xMB");
            country.setCountryFlag("xre6dyqgYOPei4GsVAiL53F1IcgRd5WyOBfjJ9ElZ8onek38R8");
            country.setCountryName("IyrILocvIu08TdpMEgIAAV6fiRF5GvCjrmM6Zf3Pj1NWaM5WtT");
            country.setCurrencyCode("7zp");
            country.setCurrencyName("h5xjuPxkqT2BSGxrnX21pwzNTlLLAGGuyH7WIgMFnovUdewPCk");
            country.setCurrencySymbol("NZqCXfJXEeuVLEHvQMj1u7gLPlHzGDHJ");
            country.setIsoNumeric(0);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("K3mL21lKK3B4IzGonLZGT6Hq8GI09D8AeVmHU9DV0uM9XwLxbn");
            state.setStateCapitalLatitude(10);
            state.setStateCapitalLongitude(11);
            state.setStateCode(2);
            state.setStateCodeChar2("wMLtJkPzvRfM59rs7tpWRXBJP78w9Ukh");
            state.setStateCodeChar3("ZJaJp7YWtsguqpsiXFPaS0NdKb7NtJ0x");
            state.setStateDescription("kF9U41sZYvSAhf6sgt9bHl4xFxACIxslbYiqLdq7m9ohcAApNx");
            state.setStateFlag("HA7dVJAUXX8xUrKamXGg7Gfzb08D4xGcYs8QHsyNGJbq2tCWAS");
            state.setStateName("VpPS6M3OSyE8pAV3k7TuU5SyENRh2PsuSHShQT5b5UblrdqYIV");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("Q5vl4mYkQhA37aSav61zWLznJzeea5eD");
            city.setCityDescription("mQA93VBcdwBJ7nWoRfnu3VGoP8GN0ouzTjC7Fh1g6OvmbTCGyx");
            city.setCityFlag("JzQnpwjjEGsmCUZ1dWFVSTEw22ii42csb8AGsK7JG5DDU8e0qy");
            city.setCityLatitude(0);
            city.setCityLongitude(8);
            city.setCityName("ep7ti8tHsNw88vink5wGH8Z7o4SJp7uvKWBojP7ZilPuWGiCap");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("HUdwc6blBpNo3TSVNmQXgd1HqacWLVHzHEG7wAC4VA1JruCxaE");
            address.setAddress2("F0CgVmOGCq18APyWiB23s28Cmn5NmJufvPlj7TUDINhRyk34Kz");
            address.setAddress3("mZC4b23YAOo5cnlwoBMDnaTpwoRAvgTq3noU8XES8uJjn5BXr0");
            address.setAddressLabel("9Vn8GiWiemM");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("jgla5YHGLbgZLJSGhvR8Zcd3uajosaXAi4F4quFXNa3G6fCoPJ");
            address.setLongitude("qV00O8tBdnEUPjXLHVNuX7pkvijbTKwFzwWcyCeUjJUpYVdQUa");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("hz98YH");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("S5IXzhiXunWpi7CfV2IGCQgLPVsvuIIwNA5Uu2mdqww5zGe0g8");
            address.setAddress2("6VVHfG9OueE74C5xmbHkDFvJexaU1MjdcbvRIkFG3JsSLJEnza");
            address.setAddress3("ldkcRLmQkalXcnirPZOSIbASoOukCO40zw9VD8I5NcL57nGEgF");
            address.setAddressLabel("m0HtYOTgmB6");
            address.setLatitude("mZHpoTWWp637n7OjwJFkA1XHLbvykctsggL9VaT8Um0yI6krMw");
            address.setLongitude("eFXaPwVTyRrHaexUWojEu1Fg7XZkwhYxQro5DTf5Ql8vz9iCkr");
            address.setVersionId(1);
            address.setZipcode("LKg60Y");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
