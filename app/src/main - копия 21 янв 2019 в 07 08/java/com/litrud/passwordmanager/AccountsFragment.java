package com.litrud.passwordmanager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class AccountsFragment extends Fragment {
    private int categoryId;
    RecyclerView accountsRecycle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_accounts, container, false);
    }

    @Override   // вызывается перед тем, как фрагмент становися видимым
    public void onStart() {
        super.onStart();

        View view = getView(); // gets the root View object of the fragment
        if (view != null) {
            // заполнить данными spinner
            String[] categoryNames = new String[Category.categories.length];
            for (int i = 0; i < categoryNames.length; i++) {
                categoryNames[i] = Category.categories[i].getName();
            }
            Spinner categoriesSpinner = (Spinner) view.findViewById(R.id.categories_spinner);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    view.getContext(),
                    android.R.layout.simple_spinner_item,
                    categoryNames
            );
            categoriesSpinner.setAdapter(adapter);
            // задать выбранный вариант
            categoriesSpinner.setSelection((int) categoryId);

            // кнопка сортировки
            // ImageButton sortButton = (ImageButton) view.findViewById(R.id.sort_button);
            // с ней пока ничего не делаем

            // заполним RecyclerView
            accountsRecycle = (RecyclerView) view.findViewById(R.id.account_recycler);

            // добавить названия аккаунтов в массив строк
            String[] accountTitles = new String[Account.accounts.length];
            for (int i = 0; i < accountTitles.length; i++) {
                accountTitles[i] = Account.accounts[i].getTitle();
            }
            // добавить id иконок категорий в массив с элементами int
            int[] accountIconsIDs = new int[Account.accounts.length];
            for (int i = 0; i < accountIconsIDs.length; i++) {
                accountIconsIDs[i] = Account.accounts[i].getIconID();
            }
            // передать массивы адаптеру
            CardsAdapter accAdapter = new CardsAdapter(accountIconsIDs, accountTitles);
            accountsRecycle.setAdapter(accAdapter);

            // чтобы карточки отображались списком, используем объект LinearLayoutManager
            LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
            accountsRecycle.setLayoutManager(layoutManager);



            //  ОБДУМАТЬ ЭТОТ КОД

            accAdapter.setListener(new CardsAdapter.Listener() {
                @Override
                public void onClick(int position) {
                    Intent intent = new Intent(AccountsActivity.this, DataActivity.class);
                    intent.putExtra(AccountsActivity.EXTRA_CATEGORYNO, position);
                    startActivity(intent);
                }
            });


        }
    }

    public void setCategoryId(int id) {
        this.categoryId = id;
    }
}
