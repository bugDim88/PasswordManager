package com.litrud.passwordmanager;

public class Account {
    private String categoryName;
    private String title;
    private String username;
    private String comments;
    private String login;
    private String password;
    private String website;
    private int iconID;

    //private Category category;

    // пока что похраним в массиве
    public static final Account[] accounts = {
            new Account("category1", "account1", "username1",
                    "comments1", "login1", "password1",
                    "www.website1.com", R.drawable.arrows),
            new Account("category2", "account2", "username2",
                    "comments2", "login2", "password2",
                    "www.website2.com", R.drawable.arrows),
            new Account("category3", "account3", "username3",
                    "comments3", "login3", "password3",
                    "www.website3.com", R.drawable.arrows),
            new Account("category4", "account4", "username4",
                    "comments4", "login4", "password4",
                    "www.website4.com", R.drawable.arrows),
            new Account("category5", "account5", "username5",
                    "comments5", "login5", "password5",
                    "www.website5.com", R.drawable.arrows),
            new Account("category6", "account6", "username6",
                    "comments6", "login6", "password6",
                    "www.website6.com", R.drawable.arrows)
    };

    public Account(String categoryName,
                   String title,
                   String username,
                   String comments,
                   String login,
                   String password,
                   String website,
                   int iconID) {
        this.categoryName = categoryName;
        this.title = title;
        this.username = username;
        this.comments = comments;
        this.login = login;
        this.password = password;
        this.website = website;
        this.iconID = iconID;
    }

    public String getCategoryName() {
        return categoryName;
    }
    public String getTitle() {
        return title;
    }
    public String getUsername() {
        return username;
    }
    public String getComments() {
        return comments;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public String getWebsite() {
        return website;
    }
    public int getIconID() {
        return iconID;
    }
}
