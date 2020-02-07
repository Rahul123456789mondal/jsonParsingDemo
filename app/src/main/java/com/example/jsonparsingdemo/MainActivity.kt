package com.example.jsonparsingdemo

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    val TAG = "MyActivity"
    private val JSON_STRING : String = "{\"Arka\":{\"id\":\"1\",\"2name\":\"Mondal\",\"address\":{\"village\":\"Palla Road\"}}}"
    var aDDress : String = ""
    var salary : String = ""

    lateinit var employeeName : TextView
    lateinit var employeeSalary : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get the reference of TextView's
        employeeName = findViewById(R.id.name)
        employeeSalary = findViewById(R.id.salary)

        try {
            // get JSONObject from JSON file
            var obj : JSONObject = JSONObject(JSON_STRING)
            // fetch JSONObject name employee
            var arka : JSONObject = obj.getJSONObject("Arka")
            var address : JSONObject = arka.getJSONObject("address")
            // get employee name and salary
            aDDress = address.getString("village")
            //Log.d(TAG,"JSON DATA : -"+name)
            //salary = employee.getString("salary")
            // set emploee name and salary in TextView's
            employeeName.text = "Id : "+aDDress
            //employeeSalary.text = "Salary : "+salary

        }catch ( e: JSONException ){
            Log.d(TAG, "Error : ${e.message}")
            e.printStackTrace()
        }
    }
}








































