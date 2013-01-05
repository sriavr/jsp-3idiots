create view wfinstancedetails as
select i.wfinstanceid,i.memberid as ownerid,concat(m.fname,' ',m.lname) as ownername, w.wfname,wi.wfitemcategory,wi.wfitemname,s.statename as state,s.statedescription,i.creationdatetime from workflowinstance i, workflowtype w, member m, workflowitem wi, states s
 where i.wftypeid = w.wftypeid and i.memberid=m.memberid and wi.wfitemid=i.wfitemid and s.stateid=i.currentstate and exists 
(
	select memberid from member where roleid in
		(select roleid from statesequencetable where 
		previousstateid in (select stateid from states where statename = 'default')
		)
	and memberid = 1011 
)
and i.memberid = 1011

union all

select i.wfinstanceid,i.memberid as ownerid,concat(m.fname,' ',m.lname) as ownername, w.wfname,wi.wfitemcategory,wi.wfitemname,s.statename as state,s.statedescription,i.creationdatetime from workflowinstance i, workflowtype w, member m, workflowitem wi, states s
 where i.wftypeid = w.wftypeid and i.memberid=m.memberid and wi.wfitemid=i.wfitemid and s.stateid=i.currentstate
 and w.wftypeid in 
(
	select wftypeid from role r, member m where m.roleid = r.roleid and m.memberid = 1011
)
 and not exists 
(
	select memberid from member where roleid in
		(select roleid from statesequencetable where 
		previousstateid in (select stateid from states where statename = 'default')
		)
	and memberid = 1011 
)
