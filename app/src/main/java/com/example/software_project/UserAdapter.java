
package com.example.software_project;

/*import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.Nullable;

import java.util.List;*/

//import androidx.annotation.NonNull;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UserAdapter  extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    Context context;
    List<User> userList;
    RecyclerView rvPrograms;
    final View.OnClickListener onClickListener = new MyOnClickListener();
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView username;
        TextView email;
        TextView password;

        public ViewHolder(@Nullable View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.edtUserName);
            // username = itemView.findViewById(R.id.usernametext);
            email = itemView.findViewById(R.id.edtEmail);
            password = itemView.findViewById(R.id.edtPassword);
        }
    }

    public UserAdapter(Context context, List<User> contactsList, RecyclerView rvPrograms){
        this.context = context;
        this.userList = contactsList;
        this.rvPrograms = rvPrograms;
    }

    @Nullable
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@Nullable ViewGroup viewGroup, int i) {
        //LayoutInflater inflater = LayoutInflater.from(context);
        //View view = inflater.inflate(R.layout.activity_settings, viewGroup, false);
        //view.setOnClickListener(onClickListener);
        //ViewHolder viewHolder = new ViewHolder(view);
        // return viewHolder;
    return null;
    }



    @Override
    public void onBindViewHolder(@Nullable UserAdapter.ViewHolder viewHolder, int i) {
        User contact = userList.get(i);
        viewHolder.username.setText(""+contact.getUsername());
        viewHolder.email.setText(contact.getEmail());
        viewHolder.password.setText(contact.getPassword());
    }



    @Override
    public int getItemCount() {
        return userList.size();
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int itemPosition = rvPrograms.getChildLayoutPosition(v);
            String item = userList.get(itemPosition).getUsername();
            Toast.makeText(context, item, Toast.LENGTH_SHORT).show();

        }
    }
}
