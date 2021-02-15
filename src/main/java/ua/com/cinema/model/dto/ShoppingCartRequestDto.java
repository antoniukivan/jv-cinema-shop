package ua.com.cinema.model.dto;

import java.util.List;

public class ShoppingCartRequestDto {
    private String email;
    private List<Long> ticketsIds;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getTicketsIds() {
        return ticketsIds;
    }

    public void setTicketsIds(List<Long> ticketsIds) {
        this.ticketsIds = ticketsIds;
    }
}
