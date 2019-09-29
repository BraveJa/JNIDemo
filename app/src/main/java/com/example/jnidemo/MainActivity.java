package com.example.jnidemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	private Button btnAdd, btnSub, btnMul, btnDiv;
	private Button btnAdd2, btnSub2, btnMul2, btnDiv2;
	private EditText inputA, inputB;
	private TextView tvResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupView();
		addListener();
	}

	private void addListener() {
		btnAdd.setOnClickListener(this);
		btnDiv.setOnClickListener(this);
		btnMul.setOnClickListener(this);
		btnSub.setOnClickListener(this);

		btnAdd2.setOnClickListener(this);
		btnDiv2.setOnClickListener(this);
		btnMul2.setOnClickListener(this);
		btnSub2.setOnClickListener(this);
	}

	private void setupView() {
		btnAdd = this.findViewById(R.id.add);
		btnDiv = this.findViewById(R.id.div);
		btnMul = this.findViewById(R.id.mul);
		btnSub = this.findViewById(R.id.sub);

		btnAdd2 = this.findViewById(R.id.add2);
		btnDiv2 = this.findViewById(R.id.div2);
		btnMul2 = this.findViewById(R.id.mul2);
		btnSub2 = this.findViewById(R.id.sub2);

		inputA = this.findViewById(R.id.inputa);
		inputB = this.findViewById(R.id.inputb);

		tvResult = this.findViewById(R.id.result);
	}


	@Override
	public void onClick(View v) {
		double result = 0;
		String strA = inputA.getText().toString();
		String strB = inputB.getText().toString();
		int a = 1;
		int b = 1;
		try {
			a = Integer.parseInt(strA);
			b = Integer.parseInt(strB);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int a = Integer.parseInt(strA);
		int b = Integer.parseInt(strB);
		switch (v.getId()) {
			case R.id.add:
				result = JNITools.add(a, b);
				break;
			case R.id.div:
				result = JNITools.div(a, b);
				break;
			case R.id.mul:
				result = JNITools.mul(a, b);
				break;
			case R.id.sub:
				result = JNITools.sub(a, b);
				break;
			case R.id.add2:
				result = JNITools2.add2(a, b);
				break;
			case R.id.div2:
				result = JNITools2.div2(a, b);
				break;
			case R.id.mul2:
				result = JNITools2.mul2(a, b);
				break;
			case R.id.sub2:
				result = JNITools2.sub2(a, b);
				break;
		}
		tvResult.setText("" + result);
	}
}
