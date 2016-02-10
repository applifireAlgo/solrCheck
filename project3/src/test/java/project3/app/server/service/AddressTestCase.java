package project3.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project3.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project3.app.server.repository.AddressRepository;
import project3.app.shared.location.Address;
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
import project3.app.shared.location.AddressType;
import project3.app.server.repository.AddressTypeRepository;
import project3.app.shared.location.City;
import project3.app.server.repository.CityRepository;
import project3.app.shared.location.Country;
import project3.app.server.repository.CountryRepository;
import project3.app.shared.location.State;
import project3.app.server.repository.StateRepository;

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
            addresstype.setAddressType("TQcMiZg0VR1enC8xvd2XygQSQoqVaFF50UmqCcwflpKb1vxOkK");
            addresstype.setAddressTypeDesc("meSSbF5LkMEq94i4KpP6hhxFvFVE5blehC3FrRV1Qnc1vuIQP5");
            addresstype.setAddressTypeIcon("IFNUTer2uMQDIyNKUePjC8DQeUl0S9td3IinX6UNhUlyCmqVce");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("Zo4Ij2he7TQvbfYikbJ7qw4B1aSs8j2l");
            city.setCityDescription("bkYjuT6QXuqOPtMBJ9NazciZ1grEYpZ7EsJZRZLzHsilcUBybk");
            city.setCityFlag("E6Mzk2U4s6OKyp7yxXaY5JpiJHhYuTJBWpQfVQOx5DeWoIaX7x");
            city.setCityLatitude(8);
            city.setCityLongitude(6);
            city.setCityName("75kG1pZQDyeO7XdZkusbZgBBvYZykf7VY8J1nM2CexnJbefrmO");
            Country country = new Country();
            country.setCapital("AjukxxF7hlRagboAKat7QBF4Q0vRahOq");
            country.setCapitalLatitude(0);
            country.setCapitalLongitude(11);
            country.setCountryCode1("GO9");
            country.setCountryCode2("1gP");
            country.setCountryFlag("JteTDZ4gMM0UYcqJ2oBdbpnap8YaSGV4AiL92pIOqhZyYwrO9q");
            country.setCountryName("y2wi49uZNl2GQl5AWSRATa7GWsn9Q0k5NTRiQ9yyseuL4thuQe");
            country.setCurrencyCode("Ti5");
            country.setCurrencyName("7NdEYQjkUjhS18XCHVFkMLLzLfjBUPDTQAOixIB8Kcg7A29Hsd");
            country.setCurrencySymbol("kfndDZY7vpa9hut4UMJAb4Cx5y3mWjpv");
            country.setIsoNumeric(11);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("RngPcoVyEdnKYwpOBqrFmr05vCiq377D2yzMQd1eBDmZQu1OW4");
            state.setStateCapitalLatitude(0);
            state.setStateCapitalLongitude(11);
            state.setStateCode(0);
            state.setStateCodeChar2("zztjXms4Pj4ZJai02FE3n4u1NnQ9KzTd");
            state.setStateCodeChar3("Wz0B5uiHOcqoNNugoVT7qrYAkX0BcUaw");
            state.setStateDescription("AuIImsM3zSUnnWpmHIv5nf3GxRJHY8OoSzTorOlyEweoIdz0Uj");
            state.setStateFlag("e2HvHFEazi0W65p5aFb3TafL140ZHhxlBXSWz0p7hmHqQRpejF");
            state.setStateName("9jwqi4YErqLRuZPWVKoZgl4gm9KIsHDGGIRLB3XzmUFtRyYJK7");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("otoKkeP408I5esiwWP7TU6AvmS2JUv2t");
            city.setCityDescription("2j8lz56mQkYWq8SZDuDnFuuv1DjczRyPYDUnW3BiJc1NkPtaDw");
            city.setCityFlag("cesSkeemGOuq2ARgnJYGSIEkYnLxZX45QLv9UmDL2kHpdmWHDA");
            city.setCityLatitude(9);
            city.setCityLongitude(9);
            city.setCityName("SwvuhUi17U6FhvZEbKB5IYMVuWKjFsnNu4bgGUswoG84o4I2rd");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("Q4IyT4yNwZN1yKR6OdqXFfqlFYAMhnnuV3rp8WE8TdoHsohs7D");
            address.setAddress2("03tup4jX4B84GT6uUtYn6mm6B5Sw98Rk4mwaQ6lQvspyYDRCHI");
            address.setAddress3("aW9HeiIfCpmITew26QktS7JI3sIrzjiqKmVRhbHvBQVYIxsNp9");
            address.setAddressLabel("3kBlYWZ163W");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("8cUH6LkBvqofPzfEw6X5OtvPQr2kl5CY1cONQoMQhOLpNpPyPL");
            address.setLongitude("zVMvjjNxZy3ERkAZgIWsgZRW7K6Trc52hLgg1I8hk9mCKVh7ZT");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("D57Yjs");
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
            address.setAddress1("QlE7kDN1Ye820BRjJUAMwetFvXxxtWtVxOtqmZX726cKGYFnTe");
            address.setAddress2("m98TCPhzFl1Uut32S3GUpqqtFRZFWdw6pPXZkVlHEIkOSpyyuR");
            address.setAddress3("QRl6cDe3k4CuVhPzY6QpSg0RHCyNTFueZmqE9WNrSHyz6fhNgb");
            address.setAddressLabel("94oBGZUj1Ji");
            address.setLatitude("qIy9Y1SrX1yvPtCKL1qaz3ULpkgoZNKOPglRZ2SwQ5MVybtXsn");
            address.setLongitude("RRwgpdb6aqWke5nCUN5JAS6jKREuHKiTWG6zQ8i9c5M0dw3Mlj");
            address.setVersionId(1);
            address.setZipcode("Cd3BC5");
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
