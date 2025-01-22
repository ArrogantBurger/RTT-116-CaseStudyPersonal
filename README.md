# RTT-116-CaseStudyPersonal
Speedrun submission site. Complete games as fast as you can and share your times with others! There are many games and categories to choose from, and users can submit speedruns for staff review, which will be posted upon approval.

Tech stack includes: SpringBoot, Spring Security, Spring Data, Java, Javascript, SQL Database, JQuery, Hibernate, Maven, HTML5/CSS.

Users enter the landing page and are greeted with a colorful display of lists and a Twitch stream embed to visually hook the viewer. The lists contain speedruns that have been recently submitted, as well as games that have the most speedrun submissions, helping guide the user to the most interesting page directories. For any other navigation, the navbar at the top of every page featuring a game search function can take users wherever they need to go.

Account creation is required for a few of the functions on the site, including submitting speedruns and commenting on posts. User credentials are protected with Spring Security, and users feature a role hirearchy that allows admins on the site to create new game titles on their personal dashboard.
