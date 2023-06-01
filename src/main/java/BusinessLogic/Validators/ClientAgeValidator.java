package BusinessLogic.Validators;

import Model.Client;

public class ClientAgeValidator implements Validator<Client> {
    private static final int MIN_AGE = 7;

    public void validate(Client t) {

        if (t.getClientAge() < MIN_AGE) {
            throw new IllegalArgumentException("The client age limit is not respected!");
        }

    }

}
