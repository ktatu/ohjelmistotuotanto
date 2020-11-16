Feature: As a registered user can log in with valid username/password-combination

    Scenario: user can login with correct password
        Given login is selected
        When correct username "jukka" and password "akkuj" are given
        Then user is logged in

    Scenario: user can not login with incorrect password
        Given login is selected
        When correct username "jukka" and incorrect password "wrong" are given
        Then user is not logged in and error message is given

    # Koodissa t‰m‰n skenaarion ja ylemm‰n skenaarion Then-stepeill‰ ei ole eroa sovelluksessa
    # En siksi tehnyt uutta Then-steppi‰, en keksinyt sille mit‰‰n tarkoitusta / ominaista
    Scenario: nonexistent user can not login to
        Given login is selected
        When incorrect username "unknown_user" and any password "pass" are given
        Then user is not logged in and error message is given

