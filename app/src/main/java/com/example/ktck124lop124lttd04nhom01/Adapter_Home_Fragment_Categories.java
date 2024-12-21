package com.example.ktck124lop124lttd04nhom01;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class Adapter_Home_Fragment_Categories extends RecyclerView.Adapter<Adapter_Home_Fragment_Categories.ViewHolder> {

    private Context context;
    private List<Category> arrcategories;

    public Adapter_Home_Fragment_Categories(Context context, List<Category> arrcategories) {
        this.context = context;
        this.arrcategories = arrcategories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_home_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int currentPosition = holder.getAdapterPosition();  // Lấy vị trí hiện tại của item
        if (currentPosition != RecyclerView.NO_POSITION) {  // Kiểm tra nếu vị trí hợp lệ
            Category category = arrcategories.get(currentPosition);  // Dùng vị trí này để lấy book
            if (category != null) {
                holder.ten.setText(category.getTenTheLoai() != null ? category.getTenTheLoai() : "Không rõ");
                holder.mota.setText(category.getMoTa() != null ? category.getMoTa() : "Không rõ");
                holder.soluong.setText(category.getSoLuong() != null ?"Số lượng sách: "+  category.getSoLuong().toString(): "Không rõ");

                // Đặt hình ảnh cho ImageView
                if (category.getAnh() != null) {
                    int imageResId = context.getResources().getIdentifier(category.getAnh(), "drawable", context.getPackageName());
                    if (imageResId != 0) {
                        holder.img.setImageResource(imageResId);
                    } else {
                        holder.img.setImageResource(R.drawable.andrzej_sapkowski);  // Ảnh mặc định
                    }
                }
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Category category = arrcategories.get(currentPosition);

                        // Tạo Bundle để truyền dữ liệu vào Fragment
                        Bundle bundle = new Bundle();
                        bundle.putInt("TheLoaiID", category.getTheLoaiID());
                        bundle.putString("TenTheLoai", category.getTenTheLoai());

                        // Gọi phương thức setCurrentPage và truyền Bundle vào Home Activity
                        if (context instanceof Home) {
                            Home homeActivity = (Home) context;
                            homeActivity.setCurrentPage(4, bundle);  // Chuyển đến All_Book_Fragment và truyền bundle
                        }
                    }
                });
            }
        }
    }
    @Override
    public int getItemCount() {
        return arrcategories.size();
    }

    // ViewHolder class dùng để tối ưu hóa hiệu suất
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ten,mota,soluong;
        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            ten = itemView.findViewById(R.id.ten);
            mota = itemView.findViewById(R.id.mota);
            img = itemView.findViewById(R.id.img);
            soluong = itemView.findViewById(R.id.a);
        }
    }
}
