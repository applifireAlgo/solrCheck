package project3.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project3.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project3.app.server.repository.CoreContactsRepository;
import project3.app.shared.contacts.CoreContacts;
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
import project3.app.shared.contacts.Gender;
import project3.app.server.repository.GenderRepository;
import project3.app.shared.location.Language;
import project3.app.server.repository.LanguageRepository;
import project3.app.shared.location.Timezone;
import project3.app.server.repository.TimezoneRepository;
import project3.app.shared.contacts.Title;
import project3.app.server.repository.TitleRepository;
import project3.app.shared.contacts.CommunicationData;
import project3.app.shared.contacts.CommunicationGroup;
import project3.app.server.repository.CommunicationGroupRepository;
import project3.app.shared.contacts.CommunicationType;
import project3.app.server.repository.CommunicationTypeRepository;
import project3.app.shared.location.Address;
import project3.app.server.repository.AddressRepository;
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
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("dol3B9xroc1D0OrDtyFCyQFEiyzttuMdEgs11UmvYcJRXck9iW");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("f1");
            language.setAlpha3("omc");
            language.setAlpha4("vcZx");
            language.setAlpha4parentid(5);
            language.setLanguage("Ye6NGaGox1l9qqwJeftVAcur1f8ZtfIIcTkbKLiYOYRDBcmwY5");
            language.setLanguageDescription("WhxLjWTLU7jUTvL5DiVBX7LLVbJwxACd5mLfXOxG09XeeYIfZc");
            language.setLanguageIcon("MkhbTNgqx44c7uoShsDrXd9AGLY8TzLnCRYcSacrMWZMCHIylP");
            language.setLanguageType("596EULmDlUmQGO82j3vySDtq8qRB8NOw");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("gQaaMTS7qxYKw2CTkpYrxIyYleG3K4nUSuwGKLfKusfei5h7eH");
            timezone.setCountry("YuS92PNgMYWgqpI6naCv7tXSHSPie2WQrbYrgiI75E0wcWwKzy");
            timezone.setGmtLabel("g68AKLSHuEVehbpWD3gUi3lrlb5TzhVtJUDOBYaeQ9oYcXYjtt");
            timezone.setTimeZoneLabel("8nnbcfe1vBCxmSoKXnsIyToxKGFZHdfcLXsk1AseEgNgWT4aCr");
            timezone.setUtcdifference(10);
            Title title = new Title();
            title.setTitles("jjTjgE80VlM85pQiBjpStvyU3pe4MCNPwev50xUIiEkGw3RlbN");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(24);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(123456789));
            corecontacts.setDateofbirth(new java.sql.Timestamp(123456789));
            corecontacts.setEmailId("HB5jJ4Qdgu7gkks1VIcUQDp0CcQIVgodMcHVZH084G5OESyfgP");
            corecontacts.setFirstName("KHqSWEuWr1cvcnpUkzx1ca8jiWggQnocDuDkGAq1ZuBfSGFkba");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("kRodtenEgUtvRwdtNhfiNVAGFl7hmQ2lr8Jbdc7rA6LvQN0XfY");
            corecontacts.setMiddleName("u7aYNUYsZajQIRjzNYZg4VHNkBEKJULmYY1peGbRwSeKT05OqS");
            corecontacts.setNativeFirstName("ZkgiUytDfUUPWwW09tZGBz6SbNEQvA5oI62KYkPl9C3ajK5M87");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("JtggXeYOV17HYwkXE4MeRDWMszGtv5qJvbidzkTAx5kVCil2Bf");
            corecontacts.setNativeMiddleName("RuPfJWj7J3jfvMKbfUoy60Ny3pgZvvcXUvCQLCj60caMOXVibm");
            corecontacts.setNativeTitle("tE5CmmgkuPLrpE8hxT3N9RjDlKgThMgHIoAwlCBRb9EIo8jkJs");
            corecontacts.setPhoneNumber("YxoEYJJiiOhp2oMF4sUr");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("t");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("esh2IVpBDDITOshB7si1SE00Ohy2unfSxzc8C2kBeN9Hx6nWYQ");
            communicationgroup.setCommGroupName("RnFbua6BeP14DsPcrwPRQbeTd0EvMBHjCIZ1Z2ukx7iK9JU1s4");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("R31rU5eC0YZBcfYZuauw7IhWPkZatkA1mbX87HRlnooeaZeGy3");
            communicationtype.setCommTypeName("3lcyFKJtlBRTAe8SMKAdBvcVbOmrRF7YqQicAgyHMn7TSUDDb2");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("w");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("RoexIWXfBv9lb4E2U7YYdvAFOYuZje0pfAU5DuxG3NI0Q4wLve");
            address.setAddress2("xGOEsk3GQA0w0BuOhvlhhJfV9Om6o0ufn3331tzvlQc67vDSSI");
            address.setAddress3("88g8cvnAFhedUyZruh5ktvOPvtkcsOVAe9SMVRVkPxfvQNaMzX");
            address.setAddressLabel("yncTtPKkuny");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("GpAGDswJ9L6JC7DR7CV62xqM80338iXMIpYh8tpuz1uXkHUMh1");
            addresstype.setAddressTypeDesc("A7B75lNgChzAmzCVKGdPF7fC6GQqCQRnbkGiu1rlt7jve0f9N7");
            addresstype.setAddressTypeIcon("p0S2FbSNpphELVdqRwOsCsOOEf0T0fpMirJ2MlWmCeFr60Ockv");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("m7Uc31WxwHI6xPUlufxvY0g0VGDSvh5S");
            city.setCityDescription("pyTf8IZlTNqYXZC3PyMdcCy7QDA5vhUCuhzUz65lR7cXdHr17q");
            city.setCityFlag("nZazrI3VNxUtUQGmT4WsjnnwjVFdr6I2b5dasgrkpuYwY6adxo");
            city.setCityLatitude(1);
            city.setCityLongitude(2);
            city.setCityName("BtNeXmb7xH91PtbDKXrVrEId9xoVpk58ByERo0kVTuCC3jFIhF");
            Country country = new Country();
            country.setCapital("M4QR90VELVBzCw0ddHTtsec47w6hUKd2");
            country.setCapitalLatitude(7);
            country.setCapitalLongitude(2);
            country.setCountryCode1("tLt");
            country.setCountryCode2("TbM");
            country.setCountryFlag("VsldHzNhtzT1g7no67BaB40mSwB9lxmpCOIEuJCBoKDyYKCEhE");
            country.setCountryName("azkTrDlNpL5wx8AYi2gQGSNy97cNlghGq6IZHzuZO1RSWGfEXC");
            country.setCurrencyCode("Gg8");
            country.setCurrencyName("A0bbVIRV4eKL89MNNlcy2lCn7nYjUGq3zdCPCEgANzRVc9b4lt");
            country.setCurrencySymbol("j1tWJ3w4sETRFmHEvhjE3aHAPa4Splmk");
            country.setIsoNumeric(3);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("n3JPXQFgleqqvc7jO1S4AY6glfhon0ZGLK3WTzk145XzWWzwgN");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(10);
            state.setStateCode(1);
            state.setStateCodeChar2("FmmxEhMIaBm8OsDS7c4wmp4BH33j9Nvx");
            state.setStateCodeChar3("FZkNHPqAGSCq51tHc9OajsW8iAW2ILrp");
            state.setStateDescription("rYHYIHdX4UxfbX7ZheMvsih3AhDumGSxz4sx1g6XcVOT4wAYL8");
            state.setStateFlag("BaKWYArb4EYqlZLdfk0k3dtralQe1t9XFYNk2UlfhYUQrblXul");
            state.setStateName("nHORqsc3bobFw33MrwzFl6MR0T7XHDQTE69wW08APNd8I9gp1J");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("saMGwvJh0OgMQu7KPfgA3RRyyEJ7xoFd");
            city.setCityDescription("fEa0s3tqFDib1MFqekJx4Ey2zsttBDLkdKTTrNqXUTh56DgSZB");
            city.setCityFlag("MGzmSR0sZfkijZVx42Brm8WrG435GFnPFVfF0LgPSTrBukEBX9");
            city.setCityLatitude(3);
            city.setCityLongitude(0);
            city.setCityName("Y1W3jEtyhCjIxsOoHsKHLAZcK7yWmEpYzkFoZ0HcYNSEIFEQ5V");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("NQUcQa4QGiGHOCPlQ2vLK3zG9KVXQfhcvrwZozVyOH3DuSrkqA");
            address.setAddress2("mo0FTRPuFlVYmB4YSNCBaVBYDgfF3n7eXncIgyB33caROawzmL");
            address.setAddress3("sQxWAV8L2brlRebkL9xfRJH1IgUIxTm44nt0Mbx0brRUAVm7if");
            address.setAddressLabel("Wccu1wLMdcf");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("XslkX30DJUdB7QKXkJ4XTL6RjRIuxQJUBZ6jmtH88OYaDpl6We");
            address.setLongitude("WAcYO6zTdkK8n19iNpnd7wleiVeelMVYRFTNCZrUIaX0J6XVF7");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("0MXASy");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(98);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(123456789));
            corecontacts.setDateofbirth(new java.sql.Timestamp(123456789));
            corecontacts.setEmailId("S0DlICVq35vFwbfVcXr5R5ciLTLtZTXN7a1p86XeudHGSK3yff");
            corecontacts.setFirstName("E7Dz2lzENBFHNPoPT06iEyKLSEbOTlEgsVS5LMUfo8WML0OSXK");
            corecontacts.setLastName("0nsdjUiQQbOe4RnPuJ69fwIO4fQwcjmIm9WQgZzSnUMFmVsi9r");
            corecontacts.setMiddleName("JWPZgWv0HJ8xVlUsRxnAaxzuMghMq0FQkJNLHDxF9TN1c0UtgO");
            corecontacts.setNativeFirstName("X5nJYHMVste40nSINzvjK6LuknoYGdDJTZ2D0ZcEjTuoB4zka3");
            corecontacts.setNativeLastName("tgaT9uhKKfl2w1r5BLydyRn0jnGBzLdiYjvSzracup7YT6U30k");
            corecontacts.setNativeMiddleName("4luGLEUZ14P65i3f01KKqHb1ocWfoPvNTXlJxED3s2JFhGbnpx");
            corecontacts.setNativeTitle("AqLgiZcKKeNiENgFQRxfX4r01lpxm7SxOhoiLJZzgicHBdaTJa");
            corecontacts.setPhoneNumber("kHn3WspC2rO2XkM8cUDu");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
