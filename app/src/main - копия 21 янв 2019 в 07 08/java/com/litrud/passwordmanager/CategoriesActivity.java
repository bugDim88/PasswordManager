package com.litrud.passwordmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class CategoriesActivity extends AppCompatActivity {
    RecyclerView categoryRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        categoryRecycler = (RecyclerView)findViewById(R.id.category_recycler);

        // добавить названия категорий в массив строк
        String[] categoryNames = new String[Category.categories.length];
        for (int i=0; i < categoryNames.length; i++) {
            categoryNames[i] = Category.categories[i].getName();
        }
        // добавить id иконок категорий в массив с элементами int
        int[] categoryIconsIDs = new int[Category.categories.length];
        for (int i=0; i < categoryIconsIDs.length; i++) {
            categoryIconsIDs[i] = Category.categories[i].getIconID();
        }

        // передать массивы адаптеру
        CardsAdapter catAdapter = new CardsAdapter(categoryIconsIDs, categoryNames);
        categoryRecycler.setAdapter(catAdapter);

        // чтобы карточки отображались таблицей, используем объект GridLayoutManager
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        categoryRecycler.setLayoutManager(layoutManager);

        catAdapter.setListener(new CardsAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(CategoriesActivity.this, AccountsActivity.class);
                intent.putExtra(AccountsActivity.EXTRA_CATEGORYNO, position);
                startActivity(intent);
            }
        });
    }
}
