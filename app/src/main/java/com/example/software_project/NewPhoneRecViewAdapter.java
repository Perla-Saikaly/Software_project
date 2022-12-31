package com.example.software_project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class NewPhoneRecViewAdapter  extends RecyclerView.Adapter{
    Context contex;
    ArrayList newImageArrayList, newNameArrayList, newStatusArrayList, newPriceArrayList;

    public NewPhoneRecViewAdapter(Context contex, ArrayList newImageArrayList, ArrayList newNameArrayList, ArrayList newStatusArrayList, ArrayList newPriceArrayList) {
        this.contex = contex;
        this.newImageArrayList = newImageArrayList;
        this.newNameArrayList = newNameArrayList;
        this.newStatusArrayList = newStatusArrayList;
        this.newPriceArrayList = newPriceArrayList;
    }

    @Nullable
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@Nullable ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_phone_list,parent,false);
        ViewHolder viewholder= new ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@Nullable RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder)holder;
        viewHolder.newPhoneImage.setImageResource(NewPhoneData.newPhoneImages[position]);
        viewHolder.NewPhoneName.setText(NewPhoneData.newPhoneNames[position]);
        viewHolder.NewPhoneStatus.setText(NewPhoneData.newPhonestatus[position]);
        viewHolder.newPhonePrice.setText(NewPhoneData.newPhonePrice[position]);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contex, "You selected new Phone", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return newNameArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView newPhoneImage;
        TextView NewPhoneName,NewPhoneStatus,newPhonePrice;
        public ViewHolder(@Nullable View itemView) {
            super(itemView);
            newPhoneImage=(ImageView)itemView.findViewById(R.id.NewPhoneImage);
            NewPhoneName=(TextView)itemView.findViewById(R.id.NewPhoneName);
            NewPhoneStatus=(TextView)itemView.findViewById(R.id.NewPhoneStatus);
            newPhonePrice=(TextView)itemView.findViewById(R.id.NewPhoneprice);


            Button btnAdd=(Button) itemView.findViewById(R.id.btnAddNew);
            btnAdd.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View view) {

                    Intent intent= new Intent(contex, Cart.class);
                    intent.putExtra("NewPhoneImage", newPhoneImage.toString());
                    intent.putExtra("NewPhoneName",NewPhoneName.getText().toString());
                    intent.putExtra("NewPhoneStatus",NewPhoneStatus.getText().toString());
                    intent.putExtra("NewPhonePrice",newPhonePrice.getText().toString());
                    contex.startActivity(intent);
                }
            });

        }
    }
}
