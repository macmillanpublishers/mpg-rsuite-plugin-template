package com.macmillan.rsuite.example.webservice;

import com.reallysi.rsuite.api.RSuiteException;
import com.reallysi.rsuite.api.extensions.Plugin;
import com.reallysi.rsuite.api.remoteapi.CallArgument;
import com.reallysi.rsuite.api.remoteapi.CallArgumentList;
import com.reallysi.rsuite.api.remoteapi.RemoteApiExecutionContext;
import com.reallysi.rsuite.api.remoteapi.RemoteApiResult;
import com.reallysi.rsuite.api.remoteapi.result.MessageDialogResult;
import com.rsicms.rsuite.helpers.webservice.RemoteApiHandlerBase;

import java.io.StringWriter;
import java.util.Map;

public class EchoWebService extends RemoteApiHandlerBase {

	@Override
	public RemoteApiResult execute(RemoteApiExecutionContext context, CallArgumentList args) throws RSuiteException {

		StringWriter writer = new StringWriter();

		writer.write("\n<h2>Context:</h2>\n");
		for (  CallArgument arg : args.getAll()) {
			writer.write( "<p>"+arg.getName()+"<b>:</b> "+arg.getValue()+"</p>\n");
		}

		for (  Map.Entry<String, Object> att : context.getAttributes().entrySet()) {
			writer.write( "<p>"+att.getKey()+"<b>:</b> "+att.getValue()+"</p>\n");
		}

		Plugin plugin = context.getPluginManager().get("mpg-rsuite-example");

		writer.write("\n<h2>Plugin: "+plugin.getId()+"</h2>\n");
		writer.write("\n<h3>version: "+plugin.getVersion()+"</h3>\n");
		writer.write("\n<h3>description: "+plugin.getDescription()+"</h3>\n");

		writer.write("\n<h2>Plugins:</h2>\n");
		for ( String p : context.getPluginManager().getPluginIds()) {
			writer.write( "<p>"+p+"</p>\n");
		}

		writer.flush();
		String msg =  writer.toString();

		return new MessageDialogResult( "Echo", msg, "500");
	}
}
