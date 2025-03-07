package me.limespace.app.views.personform;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import me.limespace.app.Person;

@PageTitle("Person Form 1")
@Route("person-form-1")
public class PersonFormView1 extends Composite<VerticalLayout> {

    PersonForm personForm = new PersonForm();

    public PersonFormView1() {
        getContent().add(personForm);
    }

    public void setPerson(Person p1) {
        Binder<Person> binder = personForm.getBinder();
        binder.readBean(p1);
        binder.validate();
    }
}
