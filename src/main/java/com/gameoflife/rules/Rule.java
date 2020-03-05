package com.gameoflife.rules;

import com.gameoflife.Matrix;

public interface Rule {

    Matrix apply(Matrix matrix);
}
