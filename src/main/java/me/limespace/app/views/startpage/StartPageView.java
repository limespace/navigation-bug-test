package me.limespace.app.views.startpage;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import me.limespace.app.Person;
import me.limespace.app.views.personform.PersonFormView1;
import me.limespace.app.views.personform.PersonFormView2;

@PageTitle("Start Page")
@Route("")
public class StartPageView extends VerticalLayout {


    public StartPageView() {
        Button pv1 = new Button("Open PersonView 1 and call setPerson()");
        pv1.addClickListener(e -> {
            Person p1 = new Person();
            p1.setFirstName("John");
            getUI().flatMap(ui -> ui.navigate(PersonFormView1.class))
                    .ifPresent(view -> view.setPerson(p1));
        });

        Button pv1a = new Button("Open PersonView 1 call setPerson() (uses push))");
        pv1a.addClickListener(e -> {
            Person p1 = new Person();
            p1.setFirstName("John");
            getUI().flatMap(ui -> ui.navigate(PersonFormView1.class))
                    .ifPresent(view -> {
                        UI.getCurrent().push();
                        view.setPerson(p1);
                    });
        });

        Button pv2 = new Button("Open PersonView 2 (uses setParameter ) ");
        pv2.addClickListener(e -> {
            Person p1 = new Person();
            p1.setFirstName("John");
            getUI().ifPresent(ui -> ui.navigate(PersonFormView2.class));
        });

        setMargin(true);

        add( pv1, pv1a, pv2);
    }

}
