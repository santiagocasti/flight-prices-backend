<h1>Project FlyMe</h1>

<p>This project was started with the intention of creating flight price notification engine similar to what 
Google Flights Alerts has released a few weeks ago.</p>

<h2>Idea</h2>
<p>The idea came up as a solution to a problem that I have: my friends and family are all over the world/europe, 
and it's always hard to decide whom to visit when while trying to optimize the variable $money$. The idea had 
the following parts:
<ul>
<li>Gather prices frequently enough to be able to identify changes in prices</li>
<li>Take some user preference regarding: 
    <ul><li>locations (where friends, family are and where in Europe the user hasn't been)</li>
    <li>traveling times/dates (long weekend trips, weekday trips, etc.)<li>
    <li>general travelling preferences (class, number of stops, duration of trips, etc.)</li></ul>
</li>
<li>Notify the user when a cheap trip is matching its preferences</li>
</ul>

<h2>Actual Development</h2>
<p>The only parts of the application developed were the data gathering from Google Flights API and storage 
in Cassandra.</p>
<p>The data gathering was done from a server in AWS using Java scheduled jobs. This jobs were limited to 
gather data at most 50 times per day, following the limitations from Google Flights API regarding free usage.</p>

<h2>Current Status</h2>
<p>This project was stopped because Google Flights added precisely the type of alerts that I was needing :)</p>
