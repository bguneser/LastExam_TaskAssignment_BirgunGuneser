package com.ford.bguneser.lastexam.adapters;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ford.bguneser.lastexam.R;
import com.ford.bguneser.lastexam.model.DbContext;
import com.ford.bguneser.lastexam.model.entity.Employee;
import com.ford.bguneser.lastexam.model.entity.Task;
import com.ford.bguneser.lastexam.model.entity.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class EmployeeListAdapter extends BaseAdapter
{

    private List<Employee> employeeList;

    int[] images = {R.drawable.ic_action_employee};
    int[] taskNotifyImages = {R.drawable.ic_action_task_notification_green, R.drawable.ic_action_task_notification_red};
    Activity activity;
    LayoutInflater layoutInflater;


//    public EmployeeListAdapter(@NonNull Context context, List<Employee> employeeList) {
//        super(context, R.layout.employeelist);
//        this.employeeList = employeeList;
//    }

    public EmployeeListAdapter(Activity activity, List<Employee> employeeList){
        layoutInflater=(LayoutInflater) activity.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
     this.employeeList=employeeList;
     this.activity=activity;

    }

    @Override
    public Object getItem(int position) {
        return employeeList.get( position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return employeeList.size();
    }

    @NonNull
    @Override
    public View getView(final int position,  @NonNull View convertView,  @NonNull ViewGroup parent) {


        View satirView;

        satirView = layoutInflater.inflate( R.layout.custom_employee_layout,null);
        ImageView imageView=(ImageView) satirView.findViewById( R.id.imageView );
        ImageView deleteTaskOnEmployeeView = (ImageView) satirView.findViewById( R.id.delete_task_on_employee );
        TextView textView_name=(TextView) satirView.findViewById( R.id.textView_name );
        TextView textView_surname=(TextView) satirView.findViewById( R.id.textView2_surname );

//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_employee_layout, parent, false);
//        }
        final Employee employee = employeeList.get(position);

        textView_name.setText(employee.getFirstname().toString());
        textView_surname.setText(employee.getLastname().toString());

        //kırmızı silme çöp kutusu
        deleteTaskOnEmployeeView.setImageResource(R.drawable.ic_action_delete_task);

        // İş geldiğine dair çanta (iş gelirse yesil gelmez ise kirmizi )
        ImageView taskNotificationImage = (ImageView) satirView.findViewById(R.id.taskNotification);


        // Calisana ait resim
        imageView.setImageResource(images[0]);


        if (employee.getTasks().size() == 0) {
            taskNotificationImage.setImageResource(taskNotifyImages[1]);
        } else {
            taskNotificationImage.setImageResource(taskNotifyImages[0]);
        }

//        final TextView textView_name = (TextView) convertView.findViewById(R.id.textView_name);
//        TextView textView_surname = (TextView) convertView.findViewById(R.id.textView2_surname);

        //ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

        //ImageView deleteTaskOnEmployeeView = (ImageView) convertView.findViewById(R.id.delete_task_on_employee);





        deleteTaskOnEmployeeView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

//                DbContext.getInstance().deleteTask( employee.getTasks().get( position ), new Callback <Void>() {
//                    @Override
//                    public void onResponse(Call <Void> call, Response <Void> response) {
//
//                        Toast.makeText( activity,employee.getTasks().get( position ).toString()+": .Task'ı sildiniz",Toast.LENGTH_SHORT ).show();
//
//                    }
//
//                    @Override
//                    public void onFailure(Call <Void> call, Throwable t) {
//
//                    }
//                } );


                DbContext.getInstance().employeedelete(employee.getId(), new Callback <Void>() {
                    @Override
                    public void onResponse(Call <Void> call, Response <Void> response) {
                        Toast.makeText( activity,employee.getId()+": .Employee'ı Sildiniz",Toast.LENGTH_SHORT ).show();

                    }

                    @Override
                    public void onFailure(Call <Void> call, Throwable t) {

                    }
                } );

            }});


        return  satirView;
    }


}
