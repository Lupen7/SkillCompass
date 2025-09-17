/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ChronolineView {

    private List<Event> events;
    private List<String> events2;

    @PostConstruct
    public void init() {
        events = new ArrayList<>();
        events.add(new Event("Applied", "15/10/2020 10:30", "pi pi-shopping-cart", "#9C27B0", "game-controller.jpg"));
        events.add(new Event("Contacted", "15/10/2020 10:30", "pi pi-shopping-cart", "#9C27B0", "game-controller.jpg"));
        events.add(new Event("Invited", "15/10/2020 14:00", "pi pi-cog", "#673AB7"));
        events.add(new Event("Interviewed", "15/10/2020 16:15", "pi pi-shopping-cart", "#FF9800"));
        events.add(new Event("Hired", "16/10/2020 10:00", "pi pi-check", "#607D8B"));
        events.add(new Event("Employment", "16/10/2020 10:00", "pi pi-check", "#607D8B"));

        events2 = new ArrayList<>();
        events2.add("2020");
        events2.add("2021");
        events2.add("2022");
        events2.add("2023");
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<String> getEvents2() {
        return events2;
    }

    public void clickOnEvent(Event event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Click on event ", event.getStatus()));
    }

    public static class Event {
        private String status;
        private String date;
        private String icon;
        private String color;
        private String image;

        public Event() {
        }

        public Event(String status, String date, String icon, String color) {
            this.status = status;
            this.date = date;
            this.icon = icon;
            this.color = color;
        }

        public Event(String status, String date, String icon, String color, String image) {
            this.status = status;
            this.date = date;
            this.icon = icon;
            this.color = color;
            this.image = image;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

}