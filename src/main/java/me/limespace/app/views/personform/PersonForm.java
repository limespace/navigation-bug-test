package me.limespace.app.views.personform;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.theme.lumo.LumoUtility;
import me.limespace.app.Person;


public class PersonForm extends VerticalLayout {

	TextField firstName = new TextField();
	TextField lastName = new TextField();
	DatePicker birthday = new DatePicker();
	TextField phoneNumber = new TextField();
	EmailField email = new EmailField();
	TextField occupation = new TextField();

	private Binder<Person> binder;

	public PersonForm() {
		createContent();
		binder = setupBinder();
	}

	private void createContent() {
		H3 h3 = new H3();
		h3.setText("Personal Information");
		h3.setWidth("100%");

		firstName.setLabel("First Name");
		lastName.setLabel("Last Name");
		birthday.setLabel("Birthday");
		phoneNumber.setLabel("Phone Number");
		email.setLabel("Email");
		occupation.setLabel("Occupation");

		setWidth("100%");
		setMaxWidth("800px");
		setHeight("min-content");
		add(h3);

		FormLayout formLayout = new FormLayout();
		formLayout.setWidth("100%");
		add(formLayout);

		formLayout.add(firstName);
		formLayout.add(lastName);
		formLayout.add(birthday);
		formLayout.add(phoneNumber);
		formLayout.add(email);
		formLayout.add(occupation);

		HorizontalLayout buttonBar = new HorizontalLayout();
		buttonBar.addClassName(LumoUtility.Gap.MEDIUM);
		buttonBar.setWidth("100%");
		buttonBar.getStyle().set("flex-grow", "1");
		add(buttonBar);

		Button buttonPrimary = new Button();
		buttonPrimary.setText("Save");
		buttonPrimary.setWidth("min-content");
		buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		Button buttonSecondary = new Button();
		buttonSecondary.setText("Cancel");
		buttonSecondary.setWidth("min-content");

		buttonBar.add(buttonPrimary);
		buttonBar.add(buttonSecondary);
	}

	private Binder<Person> setupBinder() {
		Binder<Person> binder = new Binder<>(Person.class);

		binder.forField( lastName)
				.asRequired("Last name is required")
				.bind(Person::getLastName, Person::setLastName)
				.setAsRequiredEnabled(true);

		binder.forField( firstName)
				.withValidator( firstName -> firstName.length() > 5, " more than 5 characters")
				.bind(Person::getFirstName, Person::setFirstName);

		binder.bindInstanceFields(this);
		return binder;
	}

	public Binder<Person> getBinder() {
		return binder;
	}
}
