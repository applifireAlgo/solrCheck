package project3.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project3.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project3.app.server.repository.LoginRepository;
import project3.app.shared.authentication.Login;
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
import project3.app.shared.contacts.CoreContacts;
import project3.app.server.repository.CoreContactsRepository;
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
import project3.app.shared.authentication.User;
import project3.app.server.repository.UserRepository;
import project3.app.shared.authentication.UserAccessDomain;
import project3.app.server.repository.UserAccessDomainRepository;
import project3.app.shared.authentication.UserAccessLevel;
import project3.app.server.repository.UserAccessLevelRepository;
import project3.app.shared.authentication.PassRecovery;
import project3.app.shared.authentication.Question;
import project3.app.server.repository.QuestionRepository;
import project3.app.shared.authentication.UserData;

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
            corecontacts.setAge(48);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(123456789));
            corecontacts.setDateofbirth(new java.sql.Timestamp(123456789));
            corecontacts.setEmailId("xw9IRsST8mAVGdaw00wDfiCgs0yWDFyCUC8R88HKrP6ZA84K9w");
            corecontacts.setFirstName("molvG7vXRniE4jOQhLrLBC6Ek8F9m2jmeJkYKCENE4fNvujvT5");
            Gender gender = new Gender();
            gender.setGender("akQNYXT63CG43TtKinceduTWlNT7sPXR5mNxakdehM0ahYW6gZ");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("8o");
            language.setAlpha3("30G");
            language.setAlpha4("myyW");
            language.setAlpha4parentid(6);
            language.setLanguage("P0fxuf372ckTAqIMmwoGK8vFRZuHbMoXvCmFkNtzRKOjBYgmJw");
            language.setLanguageDescription("ojE1DsUlrUoRO34BpqLwplksEbYhMu0v6NQvMQrdkpqeDoUGxC");
            language.setLanguageIcon("DuWqA2IkzaeOBp6OMiavNO09kAfwurSVHGgOf6Tmvq6QKsrXlx");
            language.setLanguageType("ZFOYUVeCUmpFGF7WDX5YU8Da0FoUCXXJ");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("yl7iHnCFCP2Ndk61wOSHlKWfvxoxRCdEDCmzXmdv8PacFgQbjL");
            timezone.setCountry("uXfDADGeo4Cyjd9wu2ff1E3quUIUfx7PugHwbOZT70aAYPSGyU");
            timezone.setGmtLabel("0k2n6g0LUXOjYcNUOKpjAVEpRjWTFQBEgwkQX60vnhG2Hjo9JF");
            timezone.setTimeZoneLabel("iEdQ9VeTDUXfnVOLrrcWZ1xvtvxigJsTSjKnFfUyRC7e3RPR79");
            timezone.setUtcdifference(11);
            Title title = new Title();
            title.setTitles("yQw2r7SaOIEsG6H7iJR87nlVDXUOjNISvzl02EGOQ0TVIWQLk6");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(5);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(123456789));
            corecontacts.setDateofbirth(new java.sql.Timestamp(123456789));
            corecontacts.setEmailId("U4jr7dg5lnG4GDsdmafdUBVmDvkwrJK29Toe77uqcy7JFJsicW");
            corecontacts.setFirstName("pDYy0qvB6vrwa2EzXhkwQGQP9T6OYMLc5UbPSnq3cbV4NK2ZXY");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("yvibKW4S8sAoIld880BNUjeYanSFahoSxrROGf3iQ0yzkWvUzk");
            corecontacts.setMiddleName("yAFXrkq7Mpm7kuuPOECFk4buDudjMcBknIHBnzc7hph9tBhQcZ");
            corecontacts.setNativeFirstName("1dr8vjioKZp6ocZA4TgdAkAZULNwjzqES51IVlYCx5n9JXqWmL");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("p9e8ZJp9JA0ESjwSl6Oja48mVbRr6ywz47jznToBawqI8dnJWs");
            corecontacts.setNativeMiddleName("mrwa8s5YjfOcVxwzalnIsQbHsariw8VdOLZqipaI9UwlbCgcqI");
            corecontacts.setNativeTitle("kZVbmMX8aFoG4fnD9Yzeifj4pnQuy70iG8EWHLO9Ly62rnltPU");
            corecontacts.setPhoneNumber("jdvByl4YfgkMkpiqakq6");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("2");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("yXDe7lHovFDdC9aVjyVVVUX1LuzByjhS08BB5XHEyqYQPxxwSI");
            communicationgroup.setCommGroupName("pDxSHKdh45lo9HM3hH0hdMoTVvGEFi1qu97QIac0vkAtvrygiW");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("AVzHepM5569xlG6A7q2eBK8Oo0v0pqq6DjCQJP1ZOQv0krymcK");
            communicationtype.setCommTypeName("XnHUM6njGVm6EcklRxCe1Fsp1OwuwV8W4eNIP4BaLtLRfJP0Bm");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("U");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("Jn0B4RufvqosBJNb6bJIiFigtpyhU3TwsNQYce0fP6GFKC7G2X");
            address.setAddress2("kZ7m3ntvgm8WnmxRbiOEhno6V6lPbSIY60fxhTTmfbtWeOpWRD");
            address.setAddress3("ulqQQYjMs3qGhdHlBaao2jUMvSRpG3tEq23c3BZARnoORCz4Nh");
            address.setAddressLabel("kMPGX8j25eW");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("TPS4F20pEZWpjHPtKCRa64KG1jjojSdu2zB9SC3CRkoVoTt3ob");
            addresstype.setAddressTypeDesc("nWMlBtV0kHAxlh0Rd2HW4x4uxY7LOvkwmJGe1zkTjH5CfcuFFz");
            addresstype.setAddressTypeIcon("AaxhicXq5mCcqBJx0B7ryq0s2c1OyHcafXd1vOAaSF4Ylaoamj");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("mIWIig21V63pds5jpiboXsQbNuFS399f");
            city.setCityDescription("PQ4CBKw9kncFZLq927WkW5zqgghU9PE366SexoxfdMbNhVRCKz");
            city.setCityFlag("YxqR2G1DiUAdvw1yNm9B1kvY83Z8DM0X4qd0oqr5lA2WtYT4tG");
            city.setCityLatitude(7);
            city.setCityLongitude(9);
            city.setCityName("VHRB8IxwvpbbdsGXjwz2TXwTr0jaljTrlWIExuuIFUEENfVwkQ");
            Country country = new Country();
            country.setCapital("ZDn2FPpPohYHSpyccMPfCrdInkmBX0cd");
            country.setCapitalLatitude(4);
            country.setCapitalLongitude(7);
            country.setCountryCode1("yqy");
            country.setCountryCode2("TY4");
            country.setCountryFlag("YI73WulOzlZQ69ntM9YfBySQIB76gwIqTJ0zPj4WyLMf2ASGTt");
            country.setCountryName("Q22MDpjIQVQpDcHKJPMGehsqThOAeXDmk7iAZKCQCbLgYbMfhP");
            country.setCurrencyCode("B6r");
            country.setCurrencyName("UcXrxNswaehhku6TULkF8rD8K9Ns1jzLuumGNOZWObTpg5yRSJ");
            country.setCurrencySymbol("DP0hFgSERCfgLJmpvPj0vxjPeQCYFxN8");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("iD1eFuKZbOccsrAvVuv336wPm0upGb0M0dLLTXLbueDQUPN1lb");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(1);
            state.setStateCode(0);
            state.setStateCodeChar2("TQGDlBKzBtpIUEAJc1pUCWC2CvpDUTP3");
            state.setStateCodeChar3("2vgJYVc9QmVmCC0Q8kMvyGnAapXp8A5Z");
            state.setStateDescription("S0DpoxnCzaRfGjHAHlPtxlcqf5Izq5eiaXmBjVnPFTTgPMR3Ld");
            state.setStateFlag("RlBtNZoOs3taKxUGu03ZC68nDAxZIXPHabFqxgB3WBM5q3sK7x");
            state.setStateName("Px9UOvEEFMefdQiS9wABBFkvuV6VbzCUSa21AhvjtoCzkrClsw");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("jjtLuRX9gBYbsYlvDXnpEp2DgKzHcCmY");
            city.setCityDescription("1UaqvvztjxFcq9yKt7mTdgfgmMC6GaEzd5fzvCU3Dwe1NPRM0P");
            city.setCityFlag("tzLclHhmP384vm6ZY7mTm0cLrdscPEpLtly7W3jqCuEaRfz5Qt");
            city.setCityLatitude(3);
            city.setCityLongitude(7);
            city.setCityName("i55oFJHv7UWk7NuQ7hOKdZhGHMuXkZ4yfn3ifU0OSo9LzexiCG");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("wfkb0RpJekeg5I8J3likw1QkrifPN9BADE19zMum0TA2KeBkJT");
            address.setAddress2("thf8Xy955DtS433F73oZGOzxOes0u2FV92bbVOx3tx2IkYoXbN");
            address.setAddress3("cDuhEm5m983cuYB7gjvIKWHmJK2EL369XIAqPbiwFvRR96O0jz");
            address.setAddressLabel("p5xbAKGbYtV");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("Wg8JDToP2bvaNAOiYToPG7SZVZiHTRxwUhKl4TVX7l9GVcBDI6");
            address.setLongitude("d9ICGv36yy7OUWj2NERTS2nQ1ltPCRaqns5RSCJ4G1fAYjjkFp");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("OroUh1");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("j4Jb4CmqeeMhayCbTiqwkNZKpF5YpzKoOG8KnKL4dKQtAae3TA");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1013);
            user.setUserAccessCode(0);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("V0CqaJyaCb0p5H6h1LCxIHWQrkXKqEq4rMq1spXE8piPTu5M0X");
            useraccessdomain.setDomainHelp("sHSYrfrEwIgaXtfRaUUwZKU1280xETmoN2MKfNR632dU13BuSl");
            useraccessdomain.setDomainIcon("b6GyTZulmabIBZARQw7EdIhRp0JrpqRz04BSCUS744ZDchz73l");
            useraccessdomain.setDomainName("aUWloH5PgwmmwgJPiwEK3jp8ysLYRHgPPzUVXLqzpiHiHo7rOb");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("pb5cHvHuvKZqZ0tzZe4gsbRm6wjnMLrxcrV8qIixsR7CQX5jYQ");
            useraccesslevel.setLevelHelp("uj8ETejE5ZY4Kt0HGOrZ2LWXxukScZz4bJxuuYqjvRzM5jA9AH");
            useraccesslevel.setLevelIcon("pj5BCT33w5PJuFycxW8lUxbfJGPnNjuCaDI2YffeIMMybAn9AL");
            useraccesslevel.setLevelName("mrY2dIizDKW8TQrvwo5m3OgQqP0hITR6KUeZzdXLcqYEVNZyIc");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("DjBc2hKuPt4lyiKspxCR77wT5zQjsIs8icXULjLwRYbENbtzj4");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2114);
            user.setUserAccessCode(9);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("yYTr3WRoF0Z1f118ksfNbnnbuxUEsZLSA5dqqrG4cjCksLhJv3");
            Question question = new Question();
            question.setLevelid(7);
            question.setQuestion("BXjFeBSIFhhg78awlDASNeXDpmDfHyXT52GTBMDX8eGNOQaCPI");
            question.setQuestionDetails("v");
            question.setQuestionIcon("bZGmQLC3uQf8C3OMfkioY4rQSbmK9qcaO313pQhfyEOsNIaQyy");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("RBgWxrXdSQqmgFI6NyqXVHmNpaFbfry7YpE3h0LLXkiEwNdtyw");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setLast5Passwords("l2EiYCbNaPhfMmD2pBTNWX5JYhFbRGnb3DYbCnEFApsFvPoRyU");
            userdata.setOneTimePassword("VvVB2FWTLEH4Jy66QxUqAVwXHOQ0B0Nn");
            userdata.setOneTimePasswordExpiry(1);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("TnRMaS2KPPFJLnVzFtJy1Nl3AEWBAr8KxVXaD5iVYh6098bYMj");
            userdata.setLast5Passwords("t6tm9Q3uhXw73CGzv0uK4mWCkLgyWMSUC3UIgymbnMbYT9clkJ");
            userdata.setOneTimePassword("ppMYMPAgMnWF0bgFG3FZ08x87CECyxfS");
            userdata.setOneTimePasswordExpiry(5);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("rRNLgxBMlypDSK43yZOhnDeQmWetdnxBQ5hfc4RDX0pgZVMvLg");
            userdata.setUser(user);
            user.setUserData(userdata);
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(11);
            login.setIsAuthenticated(true);
            login.setLoginId("y4VPbgChSAWb4S1WaBxjdJQtKtsRyEnos1V04d4h48wdbZbCca");
            login.setServerAuthImage("LyoPPF4rIc8YDW9eEyOSvRVNHoKtSiyx");
            login.setServerAuthText("RDqoyVtf66lNF6Xv");
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
            login.setFailedLoginAttempts(8);
            login.setLoginId("lw06Tio3ekPsyI7t08n1RTDVZDMbAs1CRGuotuanOhdyum9V1B");
            login.setServerAuthImage("rwcNbFtBMFxVtjMjo0QN2yOEfkJuEj8s");
            login.setServerAuthText("zuXVdqj2QF4sDRgC");
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
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
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
