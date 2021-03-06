/*******************************************************************************
 * Copyright (c) 2017 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.cdi12.test.implicitEJB.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.NoSuchEJBException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.ws.cdi12.test.implicitEJB.InjectedBean1;

@WebServlet("/")
public class TestServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private InjectedBean1 bean1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        try {
            String state = bean1.getData();
            out.println("Test Sucessful! - " + state);
        } catch (NoSuchEJBException e) {
            out.println("NoSuchEJBException");
            e.printStackTrace(out);
        }
    }
}