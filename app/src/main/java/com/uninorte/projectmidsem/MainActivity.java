package com.uninorte.projectmidsem;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout mDrawerLayout;
    ExpandableListAdapter mMenuAdapter;
    ExpandableListView expandableList;
    List<ExpandedMenuModel> listDataHeader;
    HashMap<ExpandedMenuModel, List<String>> listDataChild;
    TextView campos;
    EditText texto;
    ConstraintLayout lycampos;
    LinearLayout principal;
    Button boton;
    TextView num;
    int i=0;

    // Test
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        expandableList = (ExpandableListView) findViewById(R.id.navigation_menu);

        prepareListData();
        mMenuAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild, expandableList);

        // setting list adapter
        expandableList.setAdapter(mMenuAdapter);

        expandableList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                int in_hd = i;
                int in_cd = i1;
                switch (in_hd) {
                    case 0:
                        switch (in_cd) {
                            case 0:

                                break;
                            case 1:
                                break;
                        }
                        break;
                    case 1:
                        switch (in_cd) {
                            case 0:
                                Intent in = new Intent(MainActivity.this, rubricas.class);
                                startActivity(in);
                                break;
                            case 1:
                                break;
                        }
                        break;
                }
                Log.d("DEBUG", "submenu item clicked " + in_hd + " " + in_cd + " ");
                return false;
            }
        });


        expandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                Log.d("DEBUG", "heading clicked");
                return false;
            }
        });




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        campos=(TextView) findViewById(R.id.tvcampo);
        texto=(EditText) findViewById(R.id.ettexto);
        lycampos=(ConstraintLayout) findViewById(R.id.camposly) ;
        principal=(LinearLayout) findViewById(R.id.principal);
        boton=(Button) findViewById(R.id.button);
        num=(TextView) findViewById(R.id.numero);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lycampos = (ConstraintLayout) View.inflate(MainActivity.this,R.layout.activity_campos, null);
                principal.addView(lycampos);
                ((TextView) lycampos.findViewById(R.id.numero)).setText(String.valueOf(i+1));
                i++;
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        item3.setIconImg(R.drawable.ic_student);
        listDataHeader.add(item3);

        // Adding child data
        List<String> heading1 = new ArrayList<>();
        heading1.add("Agregar asignatura");
        heading1.add("Ver asignatura");

        List<String> heading2 = new ArrayList<>();
        heading2.add("Agregar rubricas");
        heading2.add("Ver rubricas");

        List<String> heading3 = new ArrayList<>();
        heading3.add("Ver lista");
        heading3.add("Opcion 2");
        heading3.add("Opcion 3");



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
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_subject) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
