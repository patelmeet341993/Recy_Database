package friendlyitsolution.com.recy_database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdpter extends RecyclerView.Adapter<MyAdpter.MyViewHolder> {

    private List<ModelClass> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvname,tvnumber;
        Button btncall,btnsms;
        ImageView btndelete;


        public MyViewHolder(View view) {
            super(view);

            tvname=view.findViewById(R.id.tvname);
            tvnumber=view.findViewById(R.id.tvnumber);
            btncall=view.findViewById(R.id.btncall);
            btndelete=view.findViewById(R.id.btndelete);
            btnsms=view.findViewById(R.id.btnsms);



        }
    }


    public MyAdpter(List<ModelClass> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final ModelClass model = moviesList.get(position);


        holder.tvnumber.setText(model.number);
        holder.tvname.setText(model.name);

        holder.btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.con,"sms :"+model.number,Toast.LENGTH_LONG).show();

            }
        });


        holder.btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.con,"Delete :"+model.number,Toast.LENGTH_LONG).show();

                if(model.isaddtocart)
                {
                    model.isaddtocart=false;
                }
                else
                {
                    model.isaddtocart=true;
                }

            }
        });

        holder.btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.con,"Call :"+model.number,Toast.LENGTH_LONG).show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
