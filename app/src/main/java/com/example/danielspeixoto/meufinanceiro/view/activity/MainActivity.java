package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.module.Logout;
import com.example.danielspeixoto.meufinanceiro.presenter.LogoutPresenter;
import com.example.danielspeixoto.meufinanceiro.view.recycler.adapter.BaseRecyclerAdapter;
import com.example.danielspeixoto.meufinanceiro.view.recycler.adapter.DrawerRecyclerAdapter;
import com.example.danielspeixoto.meufinanceiro.view.recycler.adapter.AllTransactionsRecyclerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements Logout.View {

    protected BaseRecyclerAdapter mAdapter;
    protected RecyclerView list;
    @BindView(R.id.drawer)
    RecyclerView drawer;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        drawer.setAdapter(new DrawerRecyclerAdapter(this));
        drawer.setLayoutManager(new LinearLayoutManager(this));
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.accept, R.string.decline);
        drawerLayout.addDrawerListener(drawerToggle);
        setUpToolbar();
        mAdapter = new AllTransactionsRecyclerAdapter(this);
        list = ButterKnife.findById(this, R.id.recentList);
        list.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        list.setAdapter(mAdapter);
    }

    @OnClick(R.id.fab)
    public void insertTransaction() {
        goToActivity(InsertTransactionActivity.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        mAdapter.refreshData();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
            case R.id.action_logout :
                new LogoutPresenter(this).logOut();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
