package com.example.clarinetmaster.testaddcourse.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.clarinetmaster.testaddcourse.Model.Course;
import com.example.clarinetmaster.testaddcourse.R;

import java.util.ArrayList;

public class CourseAdapter extends ArrayAdapter<Course> {

    private Context context;
    private int resource;
    private ArrayList<Course> courseArrayList;

    public CourseAdapter(Context context, int resource, ArrayList<Course> courseArrayList){
        super(context, resource, courseArrayList);
        this.context = context;
        this.resource = resource;
        this.courseArrayList = courseArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemLayout = convertView;

        if (itemLayout == null) {
            itemLayout = View.inflate(context, resource, null);
        }

        TextView courseName = (TextView) itemLayout.findViewById(R.id.course);
        TextView learn = (TextView) itemLayout.findViewById(R.id.learn);
        TextView learntime = (TextView) itemLayout.findViewById(R.id.learntime);
        TextView test = (TextView) itemLayout.findViewById(R.id.test);
        TextView testtime = (TextView) itemLayout.findViewById(R.id.testtime);
        TextView desc = (TextView) itemLayout.findViewById(R.id.desc);

        Course course = courseArrayList.get(position);

        String cName = course.getCourseName();
        courseName.setText(cName);

        String l = course.getCourseDay();
        learn.setText(l);

        String lt = course.getLearnStart() + " to " + course.getLearnFinish();
        learntime.setText(lt);

        String t = course.getTestDay();
        test.setText(t);

        String tt = course.getTestStart() + " to " + course.getTestFinish();
        testtime.setText(tt);

        String d = course.getCourseDesc();
        desc.setText(d);

        return itemLayout;
    }
}
