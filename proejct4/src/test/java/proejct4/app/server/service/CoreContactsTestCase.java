package proejct4.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import proejct4.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import proejct4.app.server.repository.CoreContactsRepository;
import proejct4.app.shared.contacts.CoreContacts;
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
import proejct4.app.shared.contacts.Gender;
import proejct4.app.server.repository.GenderRepository;
import proejct4.app.shared.location.Language;
import proejct4.app.server.repository.LanguageRepository;
import proejct4.app.shared.location.Timezone;
import proejct4.app.server.repository.TimezoneRepository;
import proejct4.app.shared.contacts.Title;
import proejct4.app.server.repository.TitleRepository;
import proejct4.app.shared.contacts.CommunicationData;
import proejct4.app.shared.contacts.CommunicationGroup;
import proejct4.app.server.repository.CommunicationGroupRepository;
import proejct4.app.shared.contacts.CommunicationType;
import proejct4.app.server.repository.CommunicationTypeRepository;
import proejct4.app.shared.location.Address;
import proejct4.app.server.repository.AddressRepository;
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
            gender.setGender("q3P4Yhu9ArGfMwlnKGRlWiMb2bAdTUxppfoEQB9UDCi7wXhvis");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Kd");
            language.setAlpha3("DYP");
            language.setAlpha4("iBKy");
            language.setAlpha4parentid(0);
            language.setLanguage("OzNJlS3512IumMPFY6PC6boNN3ILBnPhuHyaB8DT1XZDYfJ6La");
            language.setLanguageDescription("aqrMg69SfQsR2e182pygAu6flNlRgD72fi2fp69XlKzYMq973v");
            language.setLanguageIcon("jnMI8ECRDWsBB0k03L0OgW07NnV01h5VGeeBQkitBXFjN7jWQ6");
            language.setLanguageType("6BmToWtcCKNMQyBYUVayfYUzTjZ1knkn");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("Iq2TVAxI0q4at1Fiyfrh4lJodRkpUARDDDAAvyLDGJsKPkAwzh");
            timezone.setCountry("xJ4dNQU73ScP2m8xkAgwY66O6AGz3sEZquAZqw4aawaxHBXpST");
            timezone.setGmtLabel("YFMPf4Yx15J47L1vOFnjX34olgLuUr9q6Xfi59AsaEAqDhBrhS");
            timezone.setTimeZoneLabel("l8UkoncPZJkRZlRvI5gp2Zqnin8SKfHaBD9dssZN5mXqxXeOdV");
            timezone.setUtcdifference(0);
            Title title = new Title();
            title.setTitles("XQ8dyNiCaxVuH4yqFz4p6Md122b88OYii0WnAs9rOqDI93ZYpW");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(117);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(123456789));
            corecontacts.setDateofbirth(new java.sql.Timestamp(123456789));
            corecontacts.setEmailId("1kLlBLw2aI05AVW8sMgZ6w4OKJO547g1EVKMacdoAuA41npruj");
            corecontacts.setFirstName("GOMTwRf0B6TKeqmvYSnSoh4IjXpHGuuJODMLbuL7URwyYhW5GI");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("iQhVohpKsS5k8AZnwF8qdZAqJWSibGLepQ8Kfm8E2ILS47Xtuo");
            corecontacts.setMiddleName("elj8At7ql8iV4nvtNVtLUs7dCqBzxbXxvXNavWYPNWi5xtnyoz");
            corecontacts.setNativeFirstName("0i9X45ssLPioBUFgMzLEM7uoWBHUXkrUcvDujWRv3Y2zcs1Odg");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("SFTP3w5E3MBS04ONsNzMlEZEzfuAxQADVpiRYNHa1581B2LQVK");
            corecontacts.setNativeMiddleName("eYHZc9kkowFbdGqtAU31YMl7oYFlkKximmD0x1t2tyWtZXQxfw");
            corecontacts.setNativeTitle("ZlXtmqaPz3QL4HIZmc7gy3YG73efFRHuET6hjyaaKTkez1b3g1");
            corecontacts.setPhoneNumber("914x1uQ8paAPHTJvQLXr");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("v");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("CGMZ77fI9VQApIIS87ORwjSG8fzYWeMcmYAAMtXwvbvJx56DlZ");
            communicationgroup.setCommGroupName("GCAE0uPWjXd5VSxsaOW0pOuqK3SNIGijEkI5nmAwMs3X3K1avZ");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("MPlRn6PXepjAFQFdAIjMIPz3q8lDCk1IiFxVRjmxUo9GnmBwub");
            communicationtype.setCommTypeName("V6FfZ5MEttBiTpu4zbv72vZ3PVlTuPcvu7T64yPmA1VGznhYCG");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("r");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("9oFpKarCP2LoAAMrVsBonXuIfIYXRXAMrs9R8VygbumxApY3et");
            address.setAddress2("MU2m2FzGtUOUYyt1fxVu0DkaIauARWNE8oCKm1V8FRpHi3vVa0");
            address.setAddress3("7ojwZzXEOBZmMlXq4jTh6YtABWPuznuEy4dgETWmlvT2JcKKYl");
            address.setAddressLabel("3lBMj6U8Hye");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("bZwzqLtmTJoKkJ0sHwjN88KERpA3nkdsWIHnnsf0zHUxQxuUmS");
            addresstype.setAddressTypeDesc("vhgPvvNs7DmkBFVTIgNgiBMf2wrUPwqz1YmpWzsx6C1U1UvVU3");
            addresstype.setAddressTypeIcon("exIjveKhlOfYdKhtj5xIEbwY5GLb8ovYnpGBlrjsvkFVoNhlZz");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("PRSnj6c3hkbYdkKrWYNO0bDW28bUQUDU");
            city.setCityDescription("x72XM46q6YPFfjoYHOD05AJ8wYoVARdhbRy6GKVjZobnYxJ0Ue");
            city.setCityFlag("mhCRNFA2i077sPWEDzUJA83tuhCdGUHRIkenDI7WbMEOrfUYkO");
            city.setCityLatitude(7);
            city.setCityLongitude(6);
            city.setCityName("xxJZi4zZLl9BQjODNoUx5k87UvC8oLtCUS3tqLVhIbq2qT8Jig");
            Country country = new Country();
            country.setCapital("FnOaxnnyWMn6mGYcuZdsf0YRzpQIsbNf");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(9);
            country.setCountryCode1("DyZ");
            country.setCountryCode2("yoK");
            country.setCountryFlag("SQBvjs0VtMNbWQuygkqSx1azZuAJC0yhEnr0Etizj6ImR4MM0k");
            country.setCountryName("PpgJqGjpxROdv23UvzE1rLeqcyfjGRk3G6rEF0mLmddlBI4RDN");
            country.setCurrencyCode("b7Z");
            country.setCurrencyName("R8F6fSkod3UDcsOkzoiOuAaQ4glj6ZPhwA1KaP1bFedBH3DTpo");
            country.setCurrencySymbol("oVqhs1ssfeiIW2LwWemaVl28qeLSammz");
            country.setIsoNumeric(11);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("LzjpXINQGOzbJAWszqtYp8wIz4LkDjrWIDJ4qOOnxWEGB1gHO3");
            state.setStateCapitalLatitude(3);
            state.setStateCapitalLongitude(11);
            state.setStateCode(2);
            state.setStateCodeChar2("pPV6gPa8Xnrw72l2Bc9MzbuHKGGumvVI");
            state.setStateCodeChar3("NXCvzQwpzmn5uQ7OOfO6r1MjOVDaN5el");
            state.setStateDescription("aEMb76VNWimPrbwzvJffHbh8sWaV50tZwU9bFI52gPD2SNomM7");
            state.setStateFlag("tC3qZcjpzB9ZioFDs8OfWdVCKTQHuvTScDAlWeg02v0I5QBnGh");
            state.setStateName("cu6EByuVibwum5dgRX2uffZGcjHuy2XmKdSFlbKaHYOYFtzWjZ");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("G4VtlnC9qsFkEkm9wnvxRFVdPI8CxlL2");
            city.setCityDescription("s7nVfIp9YkTJmIokl7C1C193Ye5kBB6c3nD4cqfDEZhMrarFIx");
            city.setCityFlag("g7CNdyvuPQWl6Y1nnwnA4BM1d37uTx9paR0PGfo9IbVY05GdPa");
            city.setCityLatitude(4);
            city.setCityLongitude(6);
            city.setCityName("9Uma2chNFg7yMs1o8EN0VY3Nl52NIpPhvoLa23W7xjvGJfPIJq");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("ldhI7c3Awl2LmP79izuE4W0OsbvSRrCMnYxeHYR5JR68EV0F0X");
            address.setAddress2("Q7OGVhQ2jaR6RcKnuqPP59PtcJFnqwA8IpfLJnuAgqo2j5VwT0");
            address.setAddress3("8jDw9GrrNw20XVdclVnlLNJc5UjZ4qsFgIKayJdAbqXZoNh4D8");
            address.setAddressLabel("7xtMiv2tgpQ");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("spY6xB2psiPYVzj7MiSDFlX746vodYOgishVyqcNO7oRwM3EfP");
            address.setLongitude("7gWcUUYAbeW23DCE2KF7ViVHzTT8L7CVagd9e8KkXJQwhpY0o5");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("RfqtVU");
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
            corecontacts.setAge(10);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(123456789));
            corecontacts.setDateofbirth(new java.sql.Timestamp(123456789));
            corecontacts.setEmailId("ZOVOksKNiJVYeDm39vAHG3AV905hw6TfI0gdVGoISFlhQxndnK");
            corecontacts.setFirstName("ScDGpT4NESg9v6EGWwZ6YZqAS2EvD0TP8SpnJU1uSCQxdKQoIx");
            corecontacts.setLastName("S3t4u69sRsgjesKjiA8PWL4DOPTOYFOu8kJBGoRqlvx7yshPHa");
            corecontacts.setMiddleName("y32UHuRUJ4OApxCSEluyu7cd7ABwfnHh7sVIoDJqWclD8jlCj0");
            corecontacts.setNativeFirstName("dpdleD44wuiYsQTgrFU3eU6YfzRTsHk6YJpqWqdKZGuqdv1boA");
            corecontacts.setNativeLastName("9tg53fij90UCsYJZFSz1M8147NdxRwT8cpQ8VIpxLM34gmMBea");
            corecontacts.setNativeMiddleName("upxPohctsH1QaVs8H18xA5EVraG87j8Brjj5k4dyvIPJJYUq2u");
            corecontacts.setNativeTitle("3oRlFVR661sxWeVgY69YpkLu9dz65gd4WsK3peJVFemTFofAdl");
            corecontacts.setPhoneNumber("TU3qoPuXuP7kfoZxIqMM");
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
