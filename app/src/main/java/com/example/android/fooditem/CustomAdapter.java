package com.example.android.fooditem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by ETORO on 17/04/2017.
 */

public class CustomAdapter extends ArrayAdapter<String> {
    String[] foodName;
    String[] ingredients;
    String[] balanced;
    int[] foodImage;
    Context context;

    public CustomAdapter (Context context, String[] foodName, String[] ingredients, String[] balanced, int[] foodImage){
        super(context, R.layout.mylistview);           //the resource is the id of the view that our custom list view be inside
        this.balanced = balanced;
        this.foodImage = foodImage;
        this.context = context;
        this.foodName = foodName;        //setFoodName(foodName);
        this.ingredients = ingredients;
    }


    // this method returns the length of the names array

    //without this method we would have an empty activity b/c the adapter would not know the size of your list
    @Override
    public int getCount() {
        return foodName.length;
    }



    // this method is used to set the values to its appropriate views
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();  //initializing the viewHolder
        if (convertView == null){

            //inflate the layout where our views are resident
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.mylistview, parent, false);


            // THIS WOULD HAVE BEEN THE CODE WITHOUT THE VIEWHOLDER
//            ImageView mFlag = (ImageView) convertView.findViewById(R.id.imageView);
//            TextView mName = (TextView) convertView.findViewById(R.id.textView);
//
//            //to set the images and text in the array to their respective views
//            mFlag.setImageResource(flags[position]);
//            mName.setText(names[position]);



            //THIS IS THE CODE WITH THE VIEWHOLDER


            mViewHolder.mFoodImage = (ImageView) convertView.findViewById(R.id.foodImage);
            mViewHolder.mFoodName = (TextView) convertView.findViewById(R.id.foodName);
            mViewHolder.mIngredients = (TextView) convertView.findViewById(R.id.ingredient);
            mViewHolder.mBalanced = (TextView) convertView.findViewById(R.id.balanced);
            convertView.setTag(mViewHolder);

        }else{
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        //to set the images and text in the array to their respective views
        mViewHolder.mFoodImage.setImageResource(foodImage[position]);
        mViewHolder.mFoodName.setText(foodName[position]);
        mViewHolder.mIngredients.setText(ingredients[position]);
        mViewHolder.mBalanced.setText(balanced[position]);





        return convertView; //returns the view xml: convertView hold the mylistview_item.xml
    }

    /**
     * this class is created to enable our scrolling ie, so that the code would not always go and check out the
     * findViewById each time thereby slowing down the scrolling
     */
    static class ViewHolder{
        ImageView mFoodImage;
        TextView mFoodName;
        TextView mIngredients;
        TextView mBalanced;
    }
}
