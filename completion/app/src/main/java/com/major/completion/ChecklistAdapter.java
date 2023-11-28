package com.major.completion;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChecklistAdapter extends RecyclerView.Adapter<ChecklistAdapter.ViewHolder> {
    private Context context;

    private List<ChecklistItem> items = new ArrayList<>();
    private List<ChecklistItem> currentList = new ArrayList<>();
    private TotalUpdateListener totalUpdateListener;

    private int currentTotal = 0;


    public ChecklistAdapter(TotalUpdateListener listener) {
        this.totalUpdateListener = listener;
        initDefaultData();
    }

    private void initDefaultData() {
        // item 1_1
        items.add(new ChecklistItem("파이썬프로그래밍", 3, false, context, 0));
        items.add(new ChecklistItem("컴퓨터프로그래밍1", 3, false, context, 0));
        items.add(new ChecklistItem("컴퓨터그래픽기초", 3, false, context, 0));
        items.add(new ChecklistItem("IT개론", 3, false, context, 0));

        // item 1_2
        items.add(new ChecklistItem("컴퓨터프로그래밍2", 3, false, context, 1));
        items.add(new ChecklistItem("웹프로그래밍기초", 3, false, context, 1));
        items.add(new ChecklistItem("객체지향프로그래밍", 3, false, context, 1));

        // item 2_1

        items.add(new ChecklistItem("JAVA", 3, false, context, 2));
        items.add(new ChecklistItem("UNIX", 3, false, context, 2));
        items.add(new ChecklistItem("자료구조", 3, false, context, 2));
        items.add(new ChecklistItem("컴퓨터네트워크", 3, false, context, 2));
        items.add(new ChecklistItem("컴퓨터구조", 3, false, context, 2));

        // item 2_2
        items.add(new ChecklistItem("DB이론및실습 ", 3, false, context, 3));
        items.add(new ChecklistItem("JSP/Servlet ", 3, false, context, 3));
        items.add(new ChecklistItem("운영체제 ", 3, false, context, 3));
        items.add(new ChecklistItem("컴퓨터네트워크2", 3, false, context, 3));
        items.add(new ChecklistItem("정보보호개론 ", 3, false, context, 3));

        //item 3_1
        items.add(new ChecklistItem("모바일프로그래밍 ", 3, false, context, 4));
        items.add(new ChecklistItem("UNIX시스템프로그래밍 ", 3, false, context, 4));
        items.add(new ChecklistItem("시스템보안실무 ", 3, false, context, 4));


        //item 3_2
        items.add(new ChecklistItem("소프트웨어공학 ", 3, false, context, 5));
        items.add(new ChecklistItem("네트워크프로그래밍 ", 3, false, context, 5));
        items.add(new ChecklistItem("네트워크보안실무 ", 3, false, context, 5));

        //item 4_1
        items.add(new ChecklistItem("프로젝트실무1(종합설계) ", 3, false, context, 6));

        //item 4_2
        items.add(new ChecklistItem("프로젝트실무2(종합설계) ", 3, false, context, 7));


        items.add(new ChecklistItem("LAB 1 (기초설계) ", 1, false, context, 8));
        items.add(new ChecklistItem("LAB 2 (기초설계)", 1, false, context, 8));
        items.add(new ChecklistItem("LAB 3 (기초설계)", 1, false, context, 8));
        items.add(new ChecklistItem("LAB 4 (기초설계)", 1, false, context, 8));
        items.add(new ChecklistItem("LAB 5 (종합설계)", 1, false, context, 8));
        items.add(new ChecklistItem("촬영실무 ", 3, false, context, 8));
        items.add(new ChecklistItem("2D 융합디자인 ", 3, false, context, 8));
        items.add(new ChecklistItem("JAVA 실무 ", 3, false, context, 8));
        items.add(new ChecklistItem("서버구축 실무 ", 3, false, context, 8));
        items.add(new ChecklistItem("디지털 시스템실험 ", 3, false, context, 8));
        items.add(new ChecklistItem("이산 구조", 3, false, context, 8));
        items.add(new ChecklistItem("대학수학", 3, false, context, 8));
        items.add(new ChecklistItem("고급 웹 프로그래밍", 3, false, context, 8));
        items.add(new ChecklistItem("시스코 네트워크", 3, false, context, 8));
        items.add(new ChecklistItem("현장실습 1", 12, false, context, 8));
        items.add(new ChecklistItem("현장실습 2", 12, false, context, 8));






        currentList.add(new ChecklistItem("파이썬프로그래밍", 3, false, context, 0));
        currentList.add(new ChecklistItem("컴퓨터프로그래밍1", 3, false, context, 0));
        currentList.add(new ChecklistItem("컴퓨터그래픽기초", 3, false, context, 0));
        currentList.add(new ChecklistItem("IT개론", 3, false, context, 0));
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ChecklistItem item = currentList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return currentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkbox_item);
            textView = itemView.findViewById(R.id.textView);

            itemView.setOnClickListener(v -> {
                ChecklistItem item = currentList.get(getAdapterPosition());

                if (item.isChecked()) {
                    item.setChecked(false);
                    checkBox.setChecked(false);
                    itemView.setAlpha(1.0f);
                } else {
                    item.setChecked(true);
                    checkBox.setChecked(true);
                    itemView.setAlpha(0.5f);
                }

                totalUpdateListener.onTotalUpdate(calculateTotalCheckedItems(), calculateTotalCredits());

                notifyDataSetChanged();
            });
        }

        public void bind(ChecklistItem item) {
            textView.setText(item.getNumber() + "학점  " + item.getText());

            if (item.isChecked()) {
                itemView.setAlpha(0.5f);
                checkBox.setChecked(true);
            } else {
                itemView.setAlpha(1.0f);
                checkBox.setChecked(false);
            }
        }
    }

    public void setItems(int spinnerIndex) {
        if (!currentList.isEmpty()) {
            for (int i = 0; i < items.size(); i++) {
                for (int j = 0; j < currentList.size(); j++) {
                    if (items.get(i).getText().equals(currentList.get(j).getText()))
                        items.set(i, currentList.get(j));
                }
            }
            currentList.clear();
        }

        for (int i = 0; i < items.size(); i++) {
            if (spinnerIndex == items.get(i).getSpinnerIndex())
                currentList.add(items.get(i));
        }
    }

    public int calculateTotalCheckedItems() {
        int total = 0;
        for (ChecklistItem item : items) {
            if (item.isChecked()) {
                total += item.getNumber();
            }
        }
        return total;
    }

    public int calculateTotalCredits() {
        int totalCredits = 0;
        for (ChecklistItem item : items) {
            if (item.isChecked()) {
                totalCredits += item.getCredits();
            }
        }
        return totalCredits;
    }
}
