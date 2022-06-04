package ru.mirea.khelimskiy.mireaproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RoomDb#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RoomDb extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String TAG = MainActivity.class.getSimpleName();
    public static App instance;
    public RoomDb() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RoomDb.
     */
    // TODO: Rename and change types and number of parameters
    public static RoomDb newInstance(String param1, String param2) {
        RoomDb fragment = new RoomDb();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            AppDatabase db = App.getInstance().getDatabase();
            EmployeeDAO employeeDao = db.EmployeeDao();
            Employee employee = new Employee();
            employee.id = 1;
            employee.name = "John Smith";
            employee.salary = 10000;
            // запись сотрудников в базу
            employeeDao.insert(employee);
            // Загрузка всех работников
            List<Employee> employees = employeeDao.getAll();
            // Получение определенного работника с id = 1
            employee = employeeDao.getById(1);
            // Обновление полей объекта
            employee.salary = 20000;
            employeeDao.update(employee);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view1 =  inflater.inflate(R.layout.fragment_room_db, container, false);
    return view1;
    }
}