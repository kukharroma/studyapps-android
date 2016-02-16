package com.cook.mvc_mvp_mvvp.mvvp;

import android.databinding.ObservableField;

/**
 * Created by roma on 16.02.16.
 */
public class ViewModel {

    private final ObservableField<String> name = new ObservableField<>();
    private final ObservableField<String> surname = new ObservableField<>();
    private final ObservableField<Integer> age = new ObservableField<>();

    public ViewModel(String name, String surname, int age){
        this.name.set(name);
        this.surname.set(surname);
        this.age.set(age);
    }

    public void loadNewInfo(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                ViewModel.this.name.set("Updated name");
                ViewModel.this.surname.set("Updated surname");
                ViewModel.this.age.set(25);
            }
        }).start();
    }

    public ObservableField<String> getName() {
        return name;
    }

    public ObservableField<String> getSurname() {
        return surname;
    }

    public ObservableField<Integer> getAge() {
        return age;
    }
}
