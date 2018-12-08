package com.alexa.datastructures.list;

import com.alexa.datastructures.list.entity.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest extends AbstractListTest{

    @Override
    protected List getList() {
        return new ArrayList();
    }
}