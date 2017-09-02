package ph.akosikaelito.android.steam_status.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Bind;
import ph.akosikaelito.android.steam_status.R;
import ph.akosikaelito.android.steam_status.models.SteamService;

/**
 * Created by johneris on 6/8/2015.
 */
public class RVContributorAdapter extends RecyclerView.Adapter<RVContributorAdapter.ContributorViewHolder> {

    List<SteamService> mContributors;
    private Context mContext;

    public RVContributorAdapter(Context context, List<SteamService> contributors) {
        mContext = context;
        mContributors = contributors;
    }

    @Override
    public ContributorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_contributor, parent, false);
        ContributorViewHolder contributorViewHolder = new ContributorViewHolder(view);
        return contributorViewHolder;
    }

    @Override
    public void onBindViewHolder(ContributorViewHolder holder, int position) {
        SteamService contributor = mContributors.get(position);
        Picasso.with(mContext).load(contributor.avatarUrl).into(holder.ivAvatar);
        holder.tvUsername.setText(contributor.userName);
        holder.tvContributions.setText("" + contributor.contributions);
    }

    @Override
    public int getItemCount() {
        return mContributors.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void changeData(List<SteamService> contributors) {
        mContributors = contributors;
        notifyDataSetChanged();
    }

    public static class ContributorViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.ivAvatar)
        ImageView ivAvatar;

        @Bind(R.id.tvUsername)
        TextView tvUsername;

        @Bind(R.id.tvContributions)
        TextView tvContributions;

        ContributorViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
