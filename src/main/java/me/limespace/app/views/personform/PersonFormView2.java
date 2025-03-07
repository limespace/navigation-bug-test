package me.limespace.app.views.personform;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.*;
import me.limespace.app.Person;

@PageTitle("Person Form 2")
@Route("person-form-2")
public class PersonFormView2 extends Composite<VerticalLayout> implements HasUrlParameter<String> {

    PersonForm personForm = new PersonForm();

    public PersonFormView2() {
        getContent().add(personForm);
    }

    public void setPerson(Person p1) {
        Binder<Person> binder = personForm.getBinder();
        binder.readBean(p1);
        binder.validate();
    }


    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
        Person p1 = new Person();
        p1.setFirstName("John");

        setPerson(p1);
    }
}
