package com.example.mysecondproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_register_code.*
import kotlinx.android.synthetic.main.fragment_register_phone.*
import java.util.concurrent.TimeUnit

class RegisterActivity : AppCompatActivity(), PhoneFragment.Listener {
    private val TAG = "RegisterActivity"
    private lateinit var mPhone: String
    private lateinit var mCallback:PhoneAuthProvider.OnVerificationStateChangedCallbacks
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()
        mDatabase = FirebaseDatabase.getInstance().reference
        mCallback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                mAuth.signInWithCredential(credential).addOnCompleteListener {
                    if (it.isSuccessful){
                        showToast("Добро пожаловать!")
                        startMainActivity()
                    } else showToast("Что-то пошло не так")
                }
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                showToast(p0.message.toString())
            }

            override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
                supportFragmentManager.beginTransaction().
                    replace(R.id.frame_layout, CodeFragment(mPhone, id)).addToBackStack(null).commit()


            }

        }

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction().
                add(R.id.frame_layout, PhoneFragment()).commit()
        }
    }

    private fun startMainActivity(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }


    override fun onNext(phone: String){
        if (phone.isNotEmpty()){
            mPhone = phone
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                mPhone,
                60,
                TimeUnit.SECONDS,
                this,
                mCallback
            )
        }else {
            showToast("Please, enter phone number")
        }
    }
}

class PhoneFragment : Fragment(){
    private lateinit var mListener: Listener

    interface Listener {

        fun onNext(phone: String)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register_phone, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        next_btn.setOnClickListener {
            val phone = phone_input.text.toString()
            mListener.onNext(phone)
        }
    }

}

class CodeFragment(val mPhone: String, val id:String) : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register_code, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val code = code_input.text.toString()
    }

}