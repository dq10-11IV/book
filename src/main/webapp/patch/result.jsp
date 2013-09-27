<script>
<% if ( request.getParameter("jsonResult") != null) {%>
	var result = <%=new String( request.getParameter("jsonResult").getBytes("iso-8859-1"), "utf-8") %>
<% } %>
</script>