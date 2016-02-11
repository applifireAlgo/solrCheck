package proejct4.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import proejct4.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import proejct4.app.server.repository.LoginRepository;
import proejct4.app.shared.authentication.Login;
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
import proejct4.app.shared.contacts.CoreContacts;
import proejct4.app.server.repository.CoreContactsRepository;
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
import proejct4.app.shared.authentication.User;
import proejct4.app.server.repository.UserRepository;
import proejct4.app.shared.authentication.UserAccessDomain;
import proejct4.app.server.repository.UserAccessDomainRepository;
import proejct4.app.shared.authentication.UserAccessLevel;
import proejct4.app.server.repository.UserAccessLevelRepository;
import proejct4.app.shared.authentication.PassRecovery;
import proejct4.app.shared.authentication.Question;
import proejct4.app.server.repository.QuestionRepository;
import proejct4.app.shared.authentication.UserData;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(65);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(123456789));
            corecontacts.setDateofbirth(new java.sql.Timestamp(123456789));
            corecontacts.setEmailId("p3sjlNk4dv6gl9XhlQQs339k2ajz7zjKvFqcyvFJ1A7H1nrgTD");
            corecontacts.setFirstName("5Vq1lfJj18PgXdtuu2vB28GOP92aDNJSjCMYNYYbAnPDjo79JR");
            Gender gender = new Gender();
            gender.setGender("iKfspdXUhhURW9e6qdnE2P1oQ6MC6Fb1Az3alqm8a1JbvF7Peu");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("dA");
            language.setAlpha3("QV1");
            language.setAlpha4("lLfu");
            language.setAlpha4parentid(7);
            language.setLanguage("n4maiJpmKubKwKnXlFR9rPtlsaMfH8BJh78zCZIFwwompxa30y");
            language.setLanguageDescription("paeTQMfiJemG3yS2ttNAhBc5lmgEhMEIutzgcUpzurSliYsjMQ");
            language.setLanguageIcon("nW2V8i7G4jKwV9BuuE4QEUvMBd6KVi1u9kawAM6j27fDqbOfgO");
            language.setLanguageType("G5D15wJsKB13WVe94X155BFJkcBTbgtr");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("91QtEg9S16pua6qgpbcrexSeriEaPh2M39dCYqTcS54FAILEyP");
            timezone.setCountry("9WrXBfTmRc3Qbja8frXjGNl4qXCyimkfrYam7mYFGNLPDyshac");
            timezone.setGmtLabel("GqDEcC0iKdngnn01q5ngKwnbM0ON9u2J2Nbeulf4oEUpOToTpR");
            timezone.setTimeZoneLabel("leoGaitNmH0JqxUSG0114pnFgvFWiEaEbp6rNuVTsXTPOE4VOf");
            timezone.setUtcdifference(3);
            Title title = new Title();
            title.setTitles("GGNy1Y13DgGr0f8xW3hiBZy25yk3ZiZYEGyXn2nrDryHFGx1mJ");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(98);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(123456789));
            corecontacts.setDateofbirth(new java.sql.Timestamp(123456789));
            corecontacts.setEmailId("HnUnDH4flmvb8eXKEJXlpwyDoz4p0G9iao4bbz2J1N8J6Qp5EG");
            corecontacts.setFirstName("aOrigtQguOLBsftiguokajuaflSRNBRcTveDvSSSmmxH3QEpjj");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("sN16nfFnlDcaVTz5IvakoaOdkxdJPiWpkl3BzmVtzFcbekFDfI");
            corecontacts.setMiddleName("FirTzDhBdsb3fm4DtLRPVx5zqcOm0DzT4uMZ9385j8OEsTLvuQ");
            corecontacts.setNativeFirstName("Hh34Pxcc8udJyqzw6d5N0ORDCLYW9x0aRzhWZXoKyNLQouiRSS");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("zAo69yXuh0EeYeWtQ0xDp1KlTjNZPBoUSfvXeMKByI7V1uWhl3");
            corecontacts.setNativeMiddleName("o7O3PSgAPzwY8XPEuXCbME1oaFR7vsyTUPAwFY5Ov3uPDERmP9");
            corecontacts.setNativeTitle("7rrPnW9hEiUSniF63uJ6diJJE4mnVuMJXQ0HdjXIVMSH71WLD5");
            corecontacts.setPhoneNumber("PBnncBuiumknILZ3bBvJ");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("f");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("SHQjRRzQ0tUiEbz3Bl3mdk7KuBn3KuRl9DIRCmrhKFlcXi3chW");
            communicationgroup.setCommGroupName("gCvuRs3aeq34Flk4HHPxQrkVkTrbGGzQWoUxdO8ZXyDhpYwH4z");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("ypnIrq2wTKek8vkOaDt58U1YUWV9OFsPy3AdJaOAl7YQ0CBvJs");
            communicationtype.setCommTypeName("7TGqMRUXYcE4TYl3vw9X7HKLc38Taaj9JRoEP87OOItqOGt3r5");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("C");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("weomUDsRbAWe83dyp3J2ke91xMghASaYVnnpKx9taoTEOcQ8sL");
            address.setAddress2("je13gkebfV8sA8F1ZN86bZxYx9N0FkOMzpRi7BBTMNqiZNSJPo");
            address.setAddress3("X4spBrxaeOSYQAZ6XW8UJM6vEYoklBZzurzHdV6l59Aij0uAEC");
            address.setAddressLabel("Y9UuOVUofct");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("wFvfxsItGHNzGJjwhPzB4ChQSx2N5T4NusvJDNz83GaUiDd9IE");
            addresstype.setAddressTypeDesc("K5csmd9lfUrEutz1aI36cxTDNhk3kNmDEsVCpWPFq3S2LK5dBv");
            addresstype.setAddressTypeIcon("oUEWUhWTNmbVqFYKANTmxjDcCj64kfR4u3ztZjKnTgcDBIWTD3");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("cKdTOmxrRqColTX0fDBiWmcivTnGpagW");
            city.setCityDescription("m9cOZhlts570C6VHczuXNpN6dvqEbzxDwdjUEwTFBIfcWuWhuy");
            city.setCityFlag("zBsMiYW5Il5yBEycMAqCX04VznSebcislvtcBtFhPGuXA0ReOv");
            city.setCityLatitude(8);
            city.setCityLongitude(5);
            city.setCityName("5TJSaAM8a2lIGzKmfB7FniSKM7oFG1m78lmGDxWbW0EzjStVKP");
            Country country = new Country();
            country.setCapital("PbRuwB3Gz4kwHPIE7NPrZWmyT6b2OaWh");
            country.setCapitalLatitude(7);
            country.setCapitalLongitude(6);
            country.setCountryCode1("e96");
            country.setCountryCode2("6yi");
            country.setCountryFlag("b6KrsxWFFoITguzXgHqkzEa6qXEXioIShb6jmLfl0B2Z7G8Za4");
            country.setCountryName("xrgOWabsL1rcWvmgqsPOXT54vXvBhitMmLroDrYr6eAbb3UwC1");
            country.setCurrencyCode("yxd");
            country.setCurrencyName("8XK5bGuE0VdoLbcMB84SD70DQdcl6ohaDJyUnMZWbTwRMr6uxY");
            country.setCurrencySymbol("AD6U7MYOhsd6oQVSfMQOBznQFkWPtgg4");
            country.setIsoNumeric(10);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("7kbgrY1UmrRfLy4BoyMGt3Q0lZ12V5CyW6KdFv4UwflKit6QEa");
            state.setStateCapitalLatitude(9);
            state.setStateCapitalLongitude(8);
            state.setStateCode(1);
            state.setStateCodeChar2("Zstnysovdv77ihVhsjrsPFoVJUIsUCMU");
            state.setStateCodeChar3("JqJKythtLyqbSwZLqL11HJ7tTUtgGmze");
            state.setStateDescription("imBYCkcp2XeEESE0i5xH1UQHsg45VIlDc7hhBl2nG3MTAATiU9");
            state.setStateFlag("zRXTyPAivoCMsTMEH3UIAcD05pQyvK2r3tQcA5YbQKzDn3aX9n");
            state.setStateName("55P7cwjuid7QrctmDd426NzU7Z2Aoepg2MWgwdkT5aC2M9RLoU");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("anYIuJ5b6lbN73sYAUeca5sPR3mA13Ye");
            city.setCityDescription("MwbsTeshScbXz1qnHQEXWiNapy61wF5PmqinalrwuKLN6w7Vw0");
            city.setCityFlag("vfr3pdR4U7pNu7KvJH3ZiEX9meLZrsx6MSCH8OHL4iRevEQFdv");
            city.setCityLatitude(1);
            city.setCityLongitude(6);
            city.setCityName("l8LTNffnUfD6mY19anI1JxxueWAakyJHzfWECFj85fTtewWtDy");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("6lLSA6pEq9Ye9s5Xl8FJPPCobGQ9HwtZ4UXTU1b7OT4OafjN6N");
            address.setAddress2("i86f1BrmDE2cVQMCQajOj3bmzUAv7fqpfqTbyML6BxHTaMef5z");
            address.setAddress3("Zqxd9TBGSSlTrXfP2BXAMl9tGJSqvzVWjWBJ5nvfvqLrDuMHmf");
            address.setAddressLabel("2hB5C6M0FXu");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("1cwHuRmI6NDJnymoKOTROWbdhenhVfVU0rN111ucMLFmENia8G");
            address.setLongitude("lhvdnn9bt46bp8yjjtALMF2wMiroqgvAqRBeOrJNQNl6FLJA9l");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("dHb3Lh");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("l3S2Q42IY3hc67D7xahgDgdkEwDHR8dkLuOTbpA4fbS45M5p5b");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3553);
            user.setUserAccessCode(7);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("UeWrmnPL1g5XwVabCwaD8x9iCIYSE1YjbN1Bhzc5GtBmq7MV7K");
            useraccessdomain.setDomainHelp("ZfhB2dEGPRhHfkoFUQCvFmbeayH9ceVrbMkVBXZDgGN2oongVY");
            useraccessdomain.setDomainIcon("pEkSA8KrfrFpSNRVuIN967YHkvUy7smF8L5s5HkAEwy6ypmgJn");
            useraccessdomain.setDomainName("gvdndisJL01qyg5FgGRDmbk0PjklK1VT5G2N3A913ZC0Bc88tk");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("T0baQ41SO4IFYfERqRts6wbmxsmFFbCBGCFpKqdsFfOs8q5HZw");
            useraccesslevel.setLevelHelp("DPzjAGVKEvQjGSFWoPxrvZbfs2b8QPWwSsziL1P41ADWEAiOdy");
            useraccesslevel.setLevelIcon("f8bfCBDB9K7N6oOYMYIEDdrUkJzy1TjYi3SPRZ1znJoFubTOQ8");
            useraccesslevel.setLevelName("z2KZW0la54bKS2bf1emiBrY4eA1njVAcNn26PMErCQpuYWozMZ");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("IyeJ9TVugmRxzsRL4RCiKMM6VcRpINzUyFpJqiQU5RxQtTux6c");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2612);
            user.setUserAccessCode(6);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("nUdKaiyXGs4jaHjSsEkYijHHi84YwA8YTxBYANvnol5CPdpgot");
            Question question = new Question();
            question.setLevelid(4);
            question.setQuestion("zcULp5D8PRcYlnZtfhKoh7jqIawMtvuCtotWwotbuh9mBbaRrz");
            question.setQuestionDetails("c");
            question.setQuestionIcon("yyMcxIapniP1HrdyDuxGZlauhfNIv6KFTvD1oyb8keVjJ3looy");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("xPbzOEOOwxK50k7MqhxMl3MwNpqHRp1tKT4LGgM5MNaOIMWXTn");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setLast5Passwords("Y3e0aYO8TTNstR4C5mhQ4LmJLkNN5s2RbPgxZiof9xZHGTVUiK");
            userdata.setOneTimePassword("cOK9Dy8DtzOeLRf36WGsiBOZuczvt3jb");
            userdata.setOneTimePasswordExpiry(11);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("kI40WNQGB3Vpgn6u0xWkSbAXtWB0PR4B5wago5pBvFlfg303cg");
            userdata.setLast5Passwords("v1YkBbItEBLWVYjCvHXKHnOb62Xe0FJ8FqEnjYEd0ik0ls1WaN");
            userdata.setOneTimePassword("vHCJxxLfdoeB1m3ndrClKBxaT6IXHRPi");
            userdata.setOneTimePasswordExpiry(2);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("zc2Ppl7x2wkZUQJJnfWn9aERkWOVchpoBsOdKf3zKlASfNBdsN");
            userdata.setUser(user);
            user.setUserData(userdata);
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(5);
            login.setIsAuthenticated(true);
            login.setLoginId("KbMlFVIhr5cN8BOtCLkrXfsT6tqheSVCJh0utLrnTI9L242Y8m");
            login.setServerAuthImage("461bTuysp1Vc31rTPg7BVTqAd0FV4ngU");
            login.setServerAuthText("Nuemh5F9fD2H2iqf");
            user.setUserId(null);
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(2);
            login.setLoginId("ezhcdr2uh82fQFTkyIm9UDXmcQsvabXqeR6MrXaRX8zDYr3Nyk");
            login.setServerAuthImage("FHRNWU4XPu8PxqmhSvruCrItngmXnY8f");
            login.setServerAuthText("9IMrFwqieJsSrYT5");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
