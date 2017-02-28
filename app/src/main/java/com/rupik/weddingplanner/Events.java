package com.rupik.weddingplanner;

/**
 * Created by macmin5 on 28/02/17.
 */

public class Events {
    String eventTitle;
    String ritual;
    ShoppingListItem shoppingListItem;
    FoodMenuItems foodMenuItems;
    GuestList guestList;
    Makeup makeup;
    Theme theme;
    SpecialToDo specialToDo;

    public FoodMenuItems getFoodMenuItems() {
        return foodMenuItems;
    }

    public GuestList getGuestList() {
        return guestList;
    }

    public Makeup getMakeup() {
        return makeup;
    }

    public ShoppingListItem getShoppingListItem() {
        return shoppingListItem;
    }

    public SpecialToDo getSpecialToDo() {
        return specialToDo;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getRitual() {
        return ritual;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void setFoodMenuItems(FoodMenuItems foodMenuItems) {
        this.foodMenuItems = foodMenuItems;
    }

    public void setGuestList(GuestList guestList) {
        this.guestList = guestList;
    }

    public void setMakeup(Makeup makeup) {
        this.makeup = makeup;
    }

    public void setRitual(String ritual) {
        this.ritual = ritual;
    }

    public void setShoppingListItem(ShoppingListItem shoppingListItem) {
        this.shoppingListItem = shoppingListItem;
    }

    public void setSpecialToDo(SpecialToDo specialToDo) {
        this.specialToDo = specialToDo;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
}
