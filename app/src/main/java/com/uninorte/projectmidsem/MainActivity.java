package com.uninorte.projectmidsem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    protected FrameLayout frameLayout;
    DrawerLayout mDrawerLayout;
    ExpandableListAdapter mMenuAdapter;
    ExpandableListView expandableList;
    List<ExpandedMenuModel> listDataHeader;
    HashMap<ExpandedMenuModel, List<String>> listDataChild;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout) findViewById(R.id.principal);
        getLayoutInflater().inflate(R.layout.main_menu_welcome, frameLayout);
        expandableList = (ExpandableListView) findViewById(R.id.navigation_menu);

        prepareListData();
        mMenuAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild, expandableList);

        // setting list adapter
        expandableList.setAdapter(mMenuAdapter);

        expandableList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                switch (i) {
                    case 0:
                        switch (i1) {
                            case 0:
                                Intent in00 = new Intent(MainActivity.this, CreateSubject.class);
                                startActivity(in00);
//                                Log.d("DEBUG", "Hicieron click en agregar asignaturas");
                                break;
                            case 1:
                                Intent in01 = new Intent(MainActivity.this, StudentListByUser.class);
                                startActivity(in01);
//                                Log.d("DEBUG", "Hicieron click en ver asignaturas");
                                break;
                        }
                        break;
                    case 1:
                        switch (i1) {
                            case 0:
                                Intent in10 = new Intent(MainActivity.this, CreateRubric.class);
                                startActivity(in10);
//                                Log.d("DEBUG", "Hicieron click en crear CreateRubric");
                                break;
                            case 1:
                                break;
                        }
                        break;

                    case 2:
                        switch (i1) {
                            case 0:
                                Intent in20 = new Intent(MainActivity.this, evaluations.class);
                                startActivity(in20);
//                                Log.d("DEBUG", "Hicieron click en crear CreateRubric");
                                break;
                            case 1:
                                break;
                        }
                        break;
                }
//                Log.d("DEBUG", "submenu item clicked " + i + " " + i1 + " ");
                return false;
            }
        });

        expandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
//                Log.d("DEBUG", "heading clicked");
                return false;
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        ExpandedMenuModel item1 = new ExpandedMenuModel();
        item1.setIconName("Asignaturas");
        item1.setIconImg(R.drawable.ic_subject);
        // Adding data header
        listDataHeader.add(item1);

        ExpandedMenuModel item2 = new ExpandedMenuModel();
        item2.setIconName("Rubricas");
        item2.setIconImg(R.drawable.ic_assessment);
        listDataHeader.add(item2);

        ExpandedMenuModel item3 = new ExpandedMenuModel();
        item3.setIconName("Evaluaciones");
        item3.setIconImg(R.drawable.ic_evaluation);
        listDataHeader.add(item3);

        // Adding child data
        List<String> heading1 = new ArrayList<>();
        heading1.add("Agregar asignatura");
        heading1.add("Lista estudiantes");
        heading1.add("Asignar evaluación");

        List<String> heading2 = new ArrayList<>();
        heading2.add("Crear rubrica");
        heading2.add("Lista rubrica");

        List<String> heading3 = new ArrayList<>();
        heading3.add("Agregar Evaluación");
        heading3.add("Opcion 2");

        listDataChild.put(listDataHeader.get(0), heading1);// Header, Child data
        listDataChild.put(listDataHeader.get(1), heading2);
        listDataChild.put(listDataHeader.get(2), heading3);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);


        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

//        return super.onOptionsItemSelected(item);
    }

}
