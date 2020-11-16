package co.edu.unab.radioagro;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class EmisoraAdapter extends RecyclerView.Adapter<EmisoraAdapter.EmisoraViewHolde> {

    ArrayList<Emisora> emisoras;
    OnItemClickListener onItemClickListener;

    public EmisoraAdapter(ArrayList<Emisora> emisoras) {
        this.emisoras = emisoras;
        this.onItemClickListener = null;
    }

    public void setEmisoras(ArrayList<Emisora> emisoras) {
        this.emisoras = emisoras;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public EmisoraViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.emisora_item, parent, false);
        return new EmisoraViewHolde(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmisoraViewHolde holder, int position) {
        holder.onBind(emisoras.get(position));
    }

    @Override
    public int getItemCount() {
        return emisoras.size();
    }

    public class EmisoraViewHolde extends RecyclerView.ViewHolder {

        ImageView ivEmisora;
        TextView tvNombre;
        TextView tvDescripcion;

        public EmisoraViewHolde(@NonNull View itemView) {
            super(itemView);

            ivEmisora = itemView.findViewById(R.id.iv_emisora);
            tvNombre = itemView.findViewById(R.id.tv_nombre_e);
            tvDescripcion = itemView.findViewById(R.id.tv_descripcion_e);

        }


        public void onBind(Emisora emisora){
            tvNombre.setText(emisora.getNombreEmisora());
            tvDescripcion.setText(emisora.getDescripcionEmisora());

            Glide.with(itemView.getContext()).load(emisora.getImagenEmisora()).into(ivEmisora);


            if (onItemClickListener!=null){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(emisora, getAdapterPosition());
                    }
                });
            }

        }
    }

    public  interface OnItemClickListener {
        void onItemClick(Emisora emisora, int posicion);
    }
}
