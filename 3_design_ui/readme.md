
#Design Principles for UI
Understand basic design principals
Understand web development using React.
Develop react applications


# UI Design Principles 

1. Make user interfaces consistent
Consistent UI means using similar design patterns, identical terminology in prompts, homogenous menus and screens, and consistent commands throughout the interface.


2. Allow users to navigate easily via shortcuts
Expert users, or users who frequent your website or use your product regularly, need shortcuts to move quickly through the interface.

Just like how most Windows users make use of the shortcut CTRL + C to quickly copy text and CTRL + V to paste it, you need to make navigation and operating user interfaces easy through shortcuts.

3. Provide informative feedback
Provide feedback through readable UI copy for all user moves. Ben Shneiderman explains: “For frequent and minor actions, the response can be modest, whereas for infrequent and major actions, the response should be more substantial.”

For example, when users are asked to create a password, your UI should offer information on how strong it should be by either giving an example of a strong password or using symbols that demonstrate how strong the user’s password currently is.


4. Design dialog to yield closure
According to Shneiderman, “Sequences of actions should be organized into groups with a beginning, middle, and end. Informative feedback at the completion of a group of actions gives users the satisfaction of accomplishment, a sense of relief, a signal to drop contingency plans from their minds, and an indicator to prepare for the next group of actions.”



5. Prevent error as much as possible
Make the UI as easy to use as possible by preventing serious user errors.
So from greying out menu items that are not available to preventing users from typing in alphabets in fields that ask for phone numbers, try to prevent error as much as possible.

This is also where usability testing comes in. As a designer, you need to ensure everything works as intended by testing the design with users before launching. It not only helps to test the functionality and usability of your product, but also helps you to understand your target audience’s needs better.




6. Allow users ways to reverse their actions easily
Offer users easy and obvious ways to reverse their steps when they’ve taken a wrong step.

Shneiderman explains: “This feature relieves anxiety, since users know that errors can be undone, and encourages exploration of unfamiliar options.”

Say someone has accidentally added the wrong information in a multi-page form, allow them to go back to that page and rectify their mistake easily without having to start all over again.


7. Minimize memory load
A key rule for making user interfaces easy for people to use is minimizing cognitive load. Cognitive load (or memory load) can reduce a user’s capacity to perform important tasks, so it’s critical that computers take over the burden of memory from them as much as they can.

For instance, don’t make users re-enter personal information every time they’re buying from your website or add their email address and name every time they log into your website.


Clarity
From recognizing interactive and static elements to making navigation intuitive, clarity is an essential part of a great UI design.



Familiarity
Do you automatically look for the menu at the top of the homepage of a new website?

Why? Because that’s where we perceive the menu to be.


## React Principles of Design 

### Composition
The key feature of React is composition of components. Components written by different people should work well together. It is important to us that you can add functionality to a component without causing rippling changes throughout the codebase.

For example, it should be possible to introduce some local state into a component without changing any of the components using it. Similarly, it should be possible to add some initialization and teardown code to any component when necessary.

There is nothing “bad” about using state or lifecycle methods in components. Like any powerful feature, they should be used in moderation, but we have no intention to remove them. On the contrary, we think they are integral parts of what makes React useful. We might enable more functional patterns in the future, but both local state and lifecycle methods will be a part of that model.

Components are often described as “just functions” but in our view they need to be more than that to be useful. In React, components describe any composable behavior, and this includes rendering, lifecycle, and state. Some external libraries like Relay augment components with other responsibilities such as describing data dependencies. It is possible that those ideas might make it back into React too in some form.



## Common Abstraction
In general we resist adding features that can be implemented in userland. We don’t want to bloat your apps with useless library code. However, there are exceptions to this.

For example, if React didn’t provide support for local state or lifecycle methods, people would create custom abstractions for them. When there are multiple abstractions competing, React can’t enforce or take advantage of the properties of either of them. It has to work with the lowest common denominator.

This is why sometimes we add features to React itself. If we notice that many components implement a certain feature in incompatible or inefficient ways, we might prefer to bake it into React. We don’t do it lightly. When we do it, it’s because we are confident that raising the abstraction level benefits the whole ecosystem. State, lifecycle methods, cross-browser event normalization are good examples of this.

We always discuss such improvement proposals with the community. You can find some of those discussions by the “big picture” label on the React issue tracker.



## Escape Hatches
React is pragmatic. It is driven by the needs of the products written at Facebook. While it is influenced by some paradigms that are not yet fully mainstream such as functional programming, staying accessible to a wide range of developers with different skills and experience levels is an explicit goal of the project.

If we want to deprecate a pattern that we don’t like, it is our responsibility to consider all existing use cases for it and educate the community about the alternatives before we deprecate it. If some pattern that is useful for building apps is hard to express in a declarative way, we will provide an imperative API for it. If we can’t figure out a perfect API for something that we found necessary in many apps, we will provide a temporary subpar working API as long as it is possible to get rid of it later and it leaves the door open for future improvements.




## Stability
We value API stability. At Facebook, we have more than 50 thousand components using React. Many other companies, including Twitter and Airbnb, are also heavy users of React. This is why we are usually reluctant to change public APIs or behavior.

However we think stability in the sense of “nothing changes” is overrated. It quickly turns into stagnation. Instead, we prefer the stability in the sense of “It is heavily used in production, and when something changes, there is a clear (and preferably automated) migration path.”

When we deprecate a pattern, we study its internal usage at Facebook and add deprecation warnings. They let us assess the impact of the change. Sometimes we back out if we see that it is too early, and we need to think more strategically about getting the codebases to the point where they are ready for this change.

If we are confident that the change is not too disruptive and the migration strategy is viable for all use cases, we release the deprecation warning to the open source community. We are closely in touch with many users of React outside of Facebook, and we monitor popular open source projects and guide them in fixing those deprecations.

Given the sheer size of the Facebook React codebase, successful internal migration is often a good indicator that other companies won’t have problems either. Nevertheless sometimes people point out additional use cases we haven’t thought of, and we add escape hatches for them or rethink our approach.

We don’t deprecate anything without a good reason. We recognize that sometimes deprecations warnings cause frustration but we add them because deprecations clean up the road for the improvements and new features that we and many people in the community consider valuable.

For example, we added a warning about unknown DOM props in React 15.2.0. Many projects were affected by this. However fixing this warning is important so that we can introduce the support for custom attributes to React. There is a reason like this behind every deprecation that we add.

When we add a deprecation warning, we keep it for the rest of the current major version, and change the behavior in the next major version. If there is a lot of repetitive manual work involved, we release a codemod script that automates most of the change. Codemods enable us to move forward without stagnation in a massive codebase, and we encourage you to use them as well.


## Interoperability
We place high value in interoperability with existing systems and gradual adoption. Facebook has a massive non-React codebase. Its website uses a mix of a server-side component system called XHP, internal UI libraries that came before React, and React itself. It is important to us that any product team can start using React for a small feature rather than rewrite their code to bet on it.

This is why React provides escape hatches to work with mutable models, and tries to work well together with other UI libraries. You can wrap an existing imperative UI into a declarative component, and vice versa. This is crucial for gradual adoption.


@import url(https://fonts.googleapis.com/css2?family=IBM+Plex+Mono:wght@400;600&family=Inter:wght@400;500;600;700&display=swap);:root{--gray-0:#f9f9f9;--gray-05:#f6f6f6;--gray-1:#eee;--gray-2:#e6e6e6;--gray-3:#ddd;--gray-4:#bbb;--gray-5:#999;--gray-6:#666;--gray-65:#555;--gray-7:#2c2c2c;--gray-8:#252525;--gray-9:#1f1f1f;--gray-10:#181818;--green:#14ae73;--green-1:#95cd7f;--green-2:#73b18a;--green-3:#4d8994;--green-4:#30619d;--green-5:#30379d;--red:#f34646;--red-1:#fdd94a;--red-2:#e0a944;--red-3:#d37d36;--red-4:#cd583c;--red-5:#ab2e3f;--blue:#07a7e6;--blue-1:#70bdee;--blue-2:#618be1;--blue-3:#5b5ed5;--blue-4:#623ac6;--blue-5:#58119f;--rainbow-1:#ff67f7;--rainbow-2:#9b78fa;--rainbow-3:#59abf7;--rainbow-4:#5eddac;--rainbow-5:#f6cd5d;--orange:#ff7e22;--yellow:#fca62a;--pink:#f57ad0;--purple:#673ece;--indigo:#5a43f1;--indigo-dark:#4509cf;--indigo-light:#969bf6;--indigo-muted:#f1f2fd;--font-family-base:"Inter",-apple-system,BlinkMacSystemFont,"Helvetica Neue",Arial,sans-serif;--font-family-monospace:Menlo,"IBM Plex Mono",Menlo,monospace;--font-family-heading:-apple-system,BlinkMacSystemFont,"Helvetica Neue",Arial,sans-serif;--font-family-nav:-apple-system,BlinkMacSystemFont,"Helvetica Neue",Arial,sans-serif;--font-color-base:var(--gray-7);--font-color-muted:var(--gray-6);--font-color-heading:var(--gray-8);--font-color-heading3:var(--gray-7);--font-color-bright:var(--gray-9);--font-color-hero-heading:var(--gray-0);--border-color:var(--gray-3);--border-color-hover:var(--gray-6);--border-radius:6px;--background-color:#eee;--card-background-color:var(--gray-0);--button-background-color:var(--gray-05);--marker:var(--indigo);--link:var(--indigo);--link-hover-color:var(--indigo-muted);--navbar:var(--gray-1);--navbar-border:var(--gray-2);--navbar-color:var(--gray-8);--navbar-color-hover:var(--gray-9);--year:var(--green);--star:var(--yellow);--post-time-color:var(--gray-6);--card-time-color:var(--gray-5);--project-time-color:var(--font-color-muted);--highlight-color:var(--green);--blockquote-background:var(--indigo-muted);--file-background:#eee;--inline-code-background-color:var(--gray-0);--theme-button-background:var(--gray-1);--theme-button-background-hover:var(--gray-2);--theme-button-border:var(--gray-3);--theme-button-border-hover:var(--gray-5);--theme-button-color:var(--gray-7);--theme-button-color-hover:var(--gray-9);--category-link:#dd4eb2;--scrollbar-color:var(--gray-3);--scrollbar-track:var(--gray-4);--content-width:1160px;--content-width--small:560px;--content-width--medium:700px;--navbar-height-large:80px;--navbar-height-small:60px}\*,:after,:before{box-sizing:border-box}html{-webkit-font-smoothing:antialiased;-moz-osx-font-smoothing:grayscale;font-family:var(--font-family-base);font-kerning:normal;font-size:16px;font-weight:400;line-height:1.6}body{background:var(--background-color);margin:0;padding:0}a{color:var(--link);text-decoration:none}blockquote,ol,p,table,ul{color:var(--font-color-base);font-size:1rem}@media screen and (min-width:700px){blockquote,ol,p,table,ul{font-size:1.05rem;letter-spacing:-.01rem;line-height:1.625}}ol,p,ul{-webkit-font-smoothing:auto;line-height:1.625;margin-bottom:1.5rem;margin-top:0}ul{padding-left:1.5rem}ol li ol,ul li ul{margin-bottom:0;margin-top:.5rem}li{line-height:1.5;margin-bottom:.5rem;padding-left:.25rem}li::marker{color:var(--marker);font-size:1.1rem;line-height:1}main{margin-top:var(--navbar-height-large)}blockquote{background:var(--blockquote-background);border-left:1px solid var(--indigo-light);border:1px solid var(--indigo-light);border-left-width:6px;border-radius:var(--border-radius);margin:2rem 0;padding:1.5rem}blockquote p{font-size:1rem;font-weight:400;line-height:1.6}blockquote :last-child{margin:0}blockquote ul{margin-top:1.5rem}blockquote strong{font-weight:700;-webkit-text-decoration-line:underline;text-decoration-line:underline;text-decoration-thickness:2px}blockquote.quotation{background:transparent;border:none;border-left:12px solid var(--border-color);border-radius:0;color:var(--font-color-base);font-family:Georgia;font-size:1.1rem;font-style:italic;padding:0 0 0 1.5rem}blockquote.quotation cite{display:block;font-size:.9rem;font-style:normal;margin-top:.5rem;text-transform:uppercase}h1,h2,h3,h4,h5{color:var(--font-color-heading);font-weight:600;line-height:1.1;margin-bottom:1.5rem;margin-top:0;scroll-margin-top:3rem}h1:not(:first-child),h2:not(:first-child),h3:not(:first-child),h4:not(:first-child){margin-top:3.5rem}h2+h3{margin-top:1.5rem!important}h2{border-bottom:1px solid var(--border-color);color:var(--font-color-heading);font-family:var(--font-family-nav);font-size:1.8rem;font-weight:700;letter-spacing:-.05rem;margin:0 0 1rem;padding-bottom:.4rem}h2.year{border-bottom:none;font-size:2rem}h2 code{font-size:1.7rem!important}h3{color:var(--font-color-heading3);font-family:var(--font-family-heading);font-size:1.5rem;font-weight:500;margin-bottom:1.25rem}h3 code{font-size:1.4rem!important}@media screen and (min-width:700px){main{margin-top:6rem}h2{font-size:2rem}h2 code{font-size:1.9rem!important}h2.year{border-bottom:none;font-size:2.3rem}h3{font-size:1.8rem;letter-spacing:-.02rem}h3 code{font-size:1.85rem!important}}h4,h4 code{font-size:1.2rem;font-weight:600;margin-bottom:1.5rem;text-transform:uppercase}h4,h4 code,h5{color:var(--font-color-base)}h5{font-family:var(--font-family-heading);font-size:1.1rem;font-weight:700;margin-bottom:1rem}h2.home-heading{align-items:center;border:0;display:flex;justify-content:space-between;margin-bottom:2rem;margin-top:2rem;padding:0}h2.home-heading .title{font-family:var(--font-family-base);font-size:1.7rem;font-weight:700;margin-bottom:0}@media screen and (min-width:700px){h2.home-heading{gap:2rem}h2.home-heading .title{font-size:2rem}}table{border:1px solid var(--border-color);border-collapse:separate;border-spacing:0;display:table;font-size:1rem;line-height:1.5;margin-bottom:1.5rem;margin-top:0;max-width:100%;overflow-x:auto;width:100%}td,th{border-bottom:1px solid var(--border-color);-webkit-hyphens:auto;-ms-hyphens:auto;hyphens:auto;padding:.5rem;text-align:left;word-break:break-word}th{background:var(--card-background-color);border-bottom:2px solid var(--border-color)}img{display:block;max-width:100%}mark{background:var(--red-1);font-weight:600}u{-webkit-text-decoration-line:underline;text-decoration-line:underline;text-decoration-thickness:2px}.container{margin-left:auto;margin-right:auto;max-width:var(--content-width);padding:0 1rem}@media screen and (min-width:700px){.container{padding:0 2rem}}.layout{display:flex;flex-direction:column;min-height:100vh}.segment{margin-bottom:2rem;margin-top:2rem}.segment.small{margin-bottom:1rem;margin-top:1rem}.segment.large{margin-bottom:3rem}.segment.first,.segment.large{margin-top:3rem}@media screen and (min-width:700px){.segment{margin-bottom:3rem;margin-top:3rem}.segment.large{margin-bottom:5rem;margin-top:5rem}.segment.small{margin-bottom:1.5rem;margin-top:1.5rem}}a.button,button{align-items:center;-webkit-appearance:none;background:var(--button-background-color);border:1px solid var(--border-color);border-radius:var(--border-radius);color:var(--font-color-base);cursor:pointer;display:inline-flex;font-family:var(--font-family-nav);font-size:1rem;font-weight:500;gap:.25rem;letter-spacing:0;line-height:1;padding:.75rem 1.2rem;white-space:nowrap}a.button.large,button.large{font-size:1.1rem;font-weight:400;padding:1rem 1.75rem}a.button.small,button.small{font-size:.9rem;padding:.5rem .6rem}a.button.highlighted{color:var(--highlight-color);font-weight:500;text-decoration:none}a.button.highlighted:hover{border-color:var(--highlight-color);color:var(--highlight-color)}a.button img,button img{margin-right:.25rem;max-height:20px;min-height:20px;min-width:20px}a.button:hover,button:hover{border-color:var(--border-color-hover);color:var(--font-color-bright)}.navigation{background:var(--background-color);border-bottom:1px solid var(--border-color);font-family:var(--font-family-nav);height:var(--navbar-height-small);left:0;position:fixed;top:0;width:100%;z-index:3}.navigation .container{display:flex;height:var(--navbar-height-small);justify-content:space-between}.navigation .nav-wrapper{display:flex}.navigation a,.navigation a:hover{background:transparent;text-decoration:none}.navigation .item.brand span,.theme-toggle span{display:none}.navigation .logo{height:24px;min-height:24px;min-width:24px;width:24px}.navigation nav{gap:.25rem}.navigation a.item,.navigation button.item,.navigation nav{align-items:center;display:flex;justify-content:space-between}.navigation a.item,.navigation button.item{border:2px solid transparent;border-left:none;border-radius:0;border-right:none;color:var(--navbar-color);cursor:pointer;font-size:.9rem;font-weight:500;gap:.5rem;margin:0 .3rem;padding:0}.nav-item-outer{align-items:center;display:flex}.nav-image{display:none;height:20px;min-height:20px;min-width:20px;width:20px}.navigation a.item.brand{align-items:center;color:var(--navbar-color);color:var(--theme-button-color);display:none;font-family:var(--font-family-base);font-size:1.1rem;font-weight:700;gap:.4rem;line-height:1;margin:0 .5rem 0 0;padding:0}.navigation a.item.active,.navigation a.item:hover,.navigation button.item.active,.navigation button.item:hover{color:var(--navbar-color-hover)}.navigation a.item.home.active,.navigation a.item.home:hover,.navigation a.item.illustration.active,.navigation a.item.illustration:hover{border-bottom-color:var(--indigo)}.navigation a.item.about.active,.navigation a.item.about:hover{border-bottom-color:var(--rainbow-3)}.navigation a.item.blog.active,.navigation a.item.blog:hover{border-bottom-color:var(--rainbow-4)}.navigation a.item.projects.active,.navigation a.item.projects:hover{border-bottom-color:var(--rainbow-5)}.navigation a.item.git-hub.active,.navigation a.item.git-hub:hover{border-bottom-color:var(--rainbow-1)}.theme-toggle{align-self:center}.theme-toggle button img{margin:0}.theme-toggle button{padding:.25rem}@media screen and (min-width:700px){.navigation{border-bottom:none;height:auto;padding-top:3rem;position:static}.navigation .nav-wrapper{display:block}.navigation a.item{font-size:1.05rem;margin:0 .3rem}.navigation a.item.brand{display:inline-flex;font-size:1.2rem;margin-bottom:1.25rem;padding:0}.navigation a.item.brand span,.theme-toggle span{display:block}.navigation .logo{height:24px;margin-right:.25rem;max-height:24px;max-width:24px;width:24px}.navigation nav{gap:1.25rem}.navigation,.navigation .container{height:var(--navbar-height-large)}.theme-toggle button{padding:.5rem}}.star{align-items:center;color:var(--star);display:flex;font-family:var(--font-family-monospace);font-size:.9rem;gap:.5rem}.star a{color:var(--font-color-muted)}.star a:hover{color:var(--font-color-bright);-webkit-text-decoration-line:underline;text-decoration-line:underline;text-decoration-thickness:2px}.stars{position:absolute;right:1rem;top:1rem}.card{background:var(--card-background-color);border:1px solid var(--border-color);border-radius:var(--border-radius);padding:1rem;position:relative}@media screen and (min-width:700px){.card.anchored{padding-bottom:3.5rem}.card.anchored.large{padding-bottom:5rem}}.card a.card-header,.card h2{border:0;color:var(--font-color-heading);display:block;font-family:var(--font-family-base);font-size:1rem;font-weight:500;line-height:1.3;margin:.1rem 0 .5rem;padding:0;text-decoration:none}.card a.card-header:hover,.card h2:hover{color:var(--font-color-bright);-webkit-text-decoration-line:underline;text-decoration-line:underline;text-decoration-thickness:2px}.card p{color:var(--font-color-muted);font-family:var(--font-family-base);font-size:.9rem;line-height:1.5;margin:0}.card.single{padding:1.5rem}.card.single p{margin:0 0 1.5rem}@media screen and (min-width:700px){.card.single{padding:2rem}}.card time{color:var(--card-time-color);display:block;font-family:var(--font-family-monospace);font-size:.9rem;letter-spacing:-.01rem}.card.muted{align-items:center;background:transparent;border:1px solid transparent;padding:0}.card.muted .gatsby-image-wrapper{height:30px;max-height:30px!important;max-width:30px!important;width:30px}.card.muted time{color:var(--font-color-muted);display:none}.card.muted h2{margin:.25rem 0 1rem}@media screen and (min-width:700px){.card{padding:1.5rem}.card.muted time{display:block}.card.muted .gatsby-image-wrapper{height:45px;max-height:45px!important;max-width:45px!important;width:45px}.card a.card-header,.card h2{font-size:1.1rem;font-weight:500}.card.muted{align-items:center;background:transparent;border:1px solid var(--border-color);padding:1rem}.stars{right:1.5rem;top:1.5rem}}main{flex:1 1}.hero-wrapper{display:grid}.hero{overflow:hidden;padding:1rem 0 0;position:relative;width:100%}.hero h1{color:var(--font-color-heading);font-size:2.2rem;font-weight:700;line-height:1.1;margin:0}p.hero-description{-webkit-font-smoothing:antialiased;color:var(--font-color-base);font-size:1rem;font-weight:500;letter-spacing:-.01rem;line-height:1.6;margin-bottom:1.5rem;margin-top:1.5rem}p.hero-description a{-webkit-text-decoration-line:underline;text-decoration-line:underline;text-decoration-thickness:2px}p.hero-description a:hover{text-decoration:none}.hero .sub-title{color:var(--font-color-muted);font-size:1.1rem;font-weight:500;margin-bottom:.5rem}@media screen and (min-width:700px){.hero-wrapper{align-items:center;gap:1.5rem;grid-template-columns:3fr 2fr}p.hero-description{font-size:1.2rem;margin-bottom:0}.hero{padding:1.5rem 0 .5rem}.hero h1{font-size:3rem}.hero.index{padding:5rem 0 3rem}}.highlight{color:var(--highlight-color)}.highlight-preview{display:grid;gap:.5rem}@media screen and (min-width:700px){.highlight-preview{gap:1rem;grid-template-columns:repeat(2,1fr)}}@media screen and (min-width:1060px){.highlight-preview{grid-template-columns:repeat(3,1fr)}}.image-preview,.project-preview{display:grid;gap:1rem}.image-preview{grid-template-columns:repeat(2,1fr)}.image-thumbnail{height:150px}@media screen and (min-width:700px){.project-preview{grid-template-columns:repeat(2,1fr)}.image-preview{grid-template-columns:repeat(3,1fr)}.image-thumbnail{height:220px}}@media screen and (min-width:1060px){.project-preview{grid-template-columns:repeat(3,1fr)}.image-preview{grid-template-columns:repeat(4,1fr)}.image-thumbnail{height:250px}}.post-preview .card p{margin-bottom:1rem}.project-preview .card time{color:var(--project-time-color)}.post-preview{display:grid;gap:1rem}@media screen and (min-width:700px){.post-preview{gap:1rem;grid-template-columns:repeat(3,1fr)}}.post-preview>div{flex:1 1}.post-preview a.button{font-size:.9rem;padding:.5rem .6rem}.post-content a{-webkit-text-decoration-line:underline;text-decoration-line:underline;text-decoration-thickness:2px}.post-content a:hover{background:var(--link);color:var(--link-hover-color);text-decoration:none}a.anchor,a.anchor:hover{background:transparent!important;color:var(--link)}a.anchor svg{fill:var(--link)}a.post{background:transparent;border-bottom:1px solid var(--border-color);display:flex;gap:1rem;padding:.4rem 0;text-decoration:none}a.post:last-of-type{border:none}a.post:hover,a.post:hover h3{color:var(--font-color-bright)}a.post:hover h3{-webkit-text-decoration-line:underline;text-decoration-line:underline;text-decoration-thickness:2px}a.post h3{color:var(--font-color-heading);font-family:var(--font-family-base);font-size:1rem;font-weight:500;line-height:1.3;margin:0}a.post time{color:var(--post-time-color);display:none;font-family:var(--font-family-monospace);font-size:.9rem;font-weight:500;margin-left:auto;white-space:nowrap}@media screen and (min-width:700px){.posts.newspaper{-webkit-column-gap:2rem;column-gap:2rem;display:grid}a.post time{display:block}a.post h3{font-size:1.1rem;font-weight:600}}.grid{display:block}@media screen and (min-width:1060px){.grid{display:grid;gap:6rem;grid-template-columns:auto 300px}}.article-content{max-width:100%;min-width:0}.links{margin-top:1rem}.post-sidebar-card{background:var(--card-background-color);border:1px solid var(--border-color);border-radius:var(--border-radius);margin:1rem 0;padding:1.5rem}.post-sidebar h2{border:none;color:var(--font-color-heading);font-size:.9rem;font-weight:700;letter-spacing:0;margin:0 0 1rem;text-transform:uppercase}.post-sidebar p,.post-sidebar ul{font-size:.9rem}.post-sidebar p:last-of-type{margin-bottom:0}.post-sidebar .tags{gap:.3rem}.post-sidebar a{-webkit-text-decoration-line:underline;text-decoration-line:underline;text-decoration-thickness:2px}.post-sidebar a:hover{text-decoration:none}.sidebar-avatar{display:block;margin-bottom:1rem;max-height:100px;max-width:100px}.list a,.sidebar-avatar{border-radius:var(--border-radius)}.list a{background-color:transparent;color:var(--font-color-base);font-size:1rem;font-weight:600;margin:0 -.3rem;padding:.1rem .5rem}.list a:hover{background:hsla(0,0%,100%,.05);color:var(--highlight-color);text-decoration:none}.links,.tags{display:flex;flex-wrap:wrap;gap:.5rem}a.tag{background:var(--button-background-color)!important;border:1px solid var(--border-color);border-radius:var(--border-radius);color:var(--font-color-base);font-size:.8rem;font-weight:400;padding:.2rem .4rem}a.tag,a.tag:hover{text-decoration:none}a.tag:hover{color:var(--font-color-bright)}a.tag.active,a.tag:hover{border-color:var(--highlight-color)}a.tag.active{color:var(--highlight-color);font-weight:600}@media screen and (min-width:700px){.categories.anchored,.links.anchored{bottom:1.5rem;left:1.5rem;position:absolute}}a.category{align-items:center;display:flex;justify-content:space-between;text-decoration:none}a.category.active,a.category.active .count,a.category:hover .count{color:var(--highlight-color)}.category .name{font-size:.9rem}.category .count{color:var(--font-color-muted);font-family:var(--font-family-monospace);font-size:.9rem;font-weight:400}.width.small{max-width:var(--content-width--small)}.width.medium{max-width:var(--content-width--medium)}.flex{display:flex;gap:1rem}.space-between{justify-content:space-between}.align-center{align-items:center}.align-end{align-items:flex-end}.desktop-only{display:none!important}@media screen and (min-width:700px){.desktop-only{display:flex!important}.mobile-only{display:none!important}.navigation a.item.about{margin-left:-1rem}}.post-image{margin-top:2rem;text-align:center}.mobile-post-image{margin-bottom:1rem}.mobile-post-image .gatsby-image-wrapper{max-height:50px;max-width:50px}@media screen and (min-width:1060px){.mobile-post-image{display:none}}.post-header{padding:1rem 0 .5rem}.post-header h1{font-size:2rem;font-weight:700;letter-spacing:-.05rem;line-height:1.2;margin:0}@media screen and (min-width:700px){.post-header h1{font-size:2.6rem;line-height:1.2}}.post-header time{color:var(--font-color-muted);display:block;font-family:var(--font-family-monospace);font-size:.9rem;font-weight:400;margin-bottom:.25rem}.footer{font-family:var(--post-font-family);padding:3rem 0}.footer section{align-items:center;display:flex;flex-direction:column;gap:1.25rem}.footer img{display:inline-block;max-height:20px;width:auto}.footer nav{display:flex;gap:.25rem;margin:0 1rem}.footer a,.footer span{align-items:center;color:var(--font-color-base);display:flex;font-size:.9rem;line-height:1.2;padding:0 .5rem}.footer a:hover{-webkit-text-decoration-line:underline;text-decoration-line:underline;text-decoration-thickness:2px}.gatsby-resp-image-wrapper{margin-left:0!important}a.gatsby-resp-image-link{background:transparent!important}.circles{display:flex;gap:1rem}.circle{border-radius:50%;height:40px;margin:.5rem 0;min-height:40px;min-width:40px;width:40px}@media screen and (min-width:700px){.circle{height:30px;min-height:30px;min-width:30px;width:30px}}.red-1{background:var(--red-1)}.red-2{background:var(--red-2)}.red-3{background:var(--red-3)}.red-4{background:var(--red-4)}.red-5{background:var(--red-5)}.green-1{background:var(--green-1)}.green-2{background:var(--green-2)}.green-3{background:var(--green-3)}.green-4{background:var(--green-4)}.green-5{background:var(--green-5)}.blue-1{background:var(--blue-1)}.blue-2{background:var(--blue-2)}.blue-3{background:var(--blue-3)}.blue-4{background:var(--blue-4)}.blue-5{background:var(--blue-5)}.rainbow-1{background:var(--rainbow-1)}.rainbow-2{background:var(--rainbow-2)}.rainbow-3{background:var(--rainbow-3)}.rainbow-4{background:var(--rainbow-4)}.rainbow-5{background:var(--rainbow-5)}.image{max-width:100%}.hero-image{max-width:250px}@media screen and (min-width:700px){.hero-image{max-width:100%}}.image-thumbnail{background-position:50%;background-repeat:no-repeat;background-size:cover;border-radius:var(--border-radius);width:100%}.text-muted{color:var(--font-color-base)}.text-medium,p.text-medium{font-size:1rem}::-webkit-scrollbar{background:var(--scrollbar-track);height:8px;width:8px}::-webkit-scrollbar-thumb{background:var(--scrollbar-color);border-radius:2px}:root{--code-font-color:#232529;--code-background-color:var(--gray-0);--code-border-color:var(--gray-3);--terminal-background-color:#fff;--terminal-bar:-webkit-linear-gradient(top,#ebebeb,#d5d5d5);--terminal-accent:#fff;--terminal-border:#cecbce;--string:#229020;--variable:#383a41;--property:#565656;--number:#da7430;--operator:#a87200;--punctuation:#5c6d74;--comment:#869496;--function:#0582b7;--keyword:#a208ba;--attribute:#a87200;--class:#c52387;--tag:#365ccd;--error:#b0292c;--code-link-hover:var(--link);--highlight-code-color:rgb(116,207,116,0.2)}pre{border:0}code\[class\*=language-\],pre\[class\*=language-\]{-webkit-font-smoothing:subpixel-antialiased;word-wrap:normal;color:var(--code-font-color);font-family:"Menlo",var(--font-family-monospace);font-size:.9rem;-webkit-hyphens:none;-ms-hyphens:none;hyphens:none;line-height:1.55;-o-tab-size:2;tab-size:2;text-align:left;white-space:pre;word-break:normal;word-spacing:normal}@media screen and (min-width:700px){code\[class\*=language-\],pre\[class\*=language-\]{font-size:.9rem}}pre\[class\*=language-\]{background:var(--code-background-color);border-radius:6px;margin-bottom:1.5rem;margin-top:1.5rem;overflow:initial;padding:1rem}code.language-text{border:none;color:var(--font-color-base)}:not(pre)>code\[class\*=language-\]{-webkit-font-smoothing:subpixel-antialiased;background:var(--inline-code-background-color);border:1px solid var(--border-color);border-radius:4px;color:var(--font-color-base);font-size:1rem;font-weight:500;padding:.2rem .3rem}:not(pre)>a code\[class\*=language-\]{color:var(--link)}:not(pre)>a code\[class\*=language-\]:hover{color:var(--code-link-hover)}code.language-shell:before{color:var(--comment);content:"$ "}.gatsby-highlight{-webkit-text-size-adjust:none;-moz-text-size-adjust:none;text-size-adjust:none;background:var(--code-background-color);border-bottom:1px solid var(--code-border-color);border-radius:0;border-top:1px solid var(--code-border-color);margin:1.5rem -1.5rem;max-width:calc(100% + 2.5rem);overflow:auto}@media screen and (min-width:700px){.gatsby-highlight{border:1px solid var(--code-border-color);border-radius:6px;margin:1.5rem 0;max-width:100%}}.gatsby-highlight\[data-language=terminal\]{background:transparent;box-shadow:none;box-shadow:0 15px 20px rgba(0,0,0,.05),0 5px 7px rgba(0,0,0,.03);margin-left:0;margin-right:0;overflow:auto;padding:0}.gatsby-highlight\[data-language=text\]{background:transparent;border:none;margin:0 0 1.5rem;padding:0}.gatsby-highlight-code-line{background-color:var(--highlight-code-color);border-left:4px solid #74cf74;display:block;margin-left:-1rem;margin-right:-1.5rem;padding-left:calc(1rem - 4px)}.gatsby-highlight-code-line .gatsby-highlight-code-line{background-color:transparent}@media screen and (min-width:700px){.gatsby-highlight-code-line{border-left:4px solid #74cf74;margin-left:-1.5rem;margin-right:-1.5rem;padding-left:calc(1.5rem - 4px)}}.gatsby-highlight pre\[class\*=language-\]{background-color:transparent;float:left;margin:0;min-width:100%;overflow:initial;padding:1.5rem}.gatsby-highlight:after{clear:both;content:"";display:table}.gatsby-highlight pre.language-terminal{-webkit-text-size-adjust:none;background:var(--terminal-background-color);border:1px solid var(--terminal-border);border-radius:6px;max-width:100%;padding:3rem 1rem 1rem;position:relative;white-space:unset}.gatsby-highlight pre.language-text{-webkit-font-smoothing:subpixel-antialiased;background:transparent;border:none;box-shadow:none;color:var(--terminal-color);margin:0;padding:0}code.language-terminal{-webkit-font-smoothing:antialiased;-webkit-text-size-adjust:none;-moz-text-size-adjust:none;text-size-adjust:none;color:var(--terminal-color);white-space:pre-wrap;word-break:break-all}pre.language-terminal:before{background:var(--terminal-bar);border-bottom:1px solid var(--border-color);border-top:1px solid var(--terminal-accent);border-top-left-radius:6px;border-top-right-radius:6px;color:#a19ea1;content:"\\2022 \\2022 \\2022";font-size:2.5rem;left:0;letter-spacing:-5px;line-height:0;margin:0;padding:15px 0 12px;position:absolute;text-indent:6px;top:0;width:100%}.filename{align-items:center;background:var(--file-background);border-bottom:1px solid var(--code-border-color);border-radius:0;border-top:1px solid var(--code-border-color);color:var(--font-color-base);display:flex;font-size:1rem;font-weight:500;justify-content:center;line-height:1.5;margin-bottom:-1.9rem;margin-left:-1.5rem;margin-right:-1.5rem;max-width:calc(100% + 2.5rem);padding:.4rem 1rem .8rem}@media screen and (min-width:700px){.filename{border:1px solid var(--code-border-color);border-top-left-radius:6px;border-top-right-radius:6px;margin-left:0;margin-right:0;max-width:100%}}.token.cdata,.token.comment,.token.doctype,.token.important,.token.prolog{color:var(--comment)}.token.punctuation{color:var(--punctuation)}.token.namespace{opacity:.7}.token.property{color:var(--property)}.token.constant,.token.deleted,.token.symbol,.token.tag{color:var(--tag)}.token.number{color:var(--number)}.token.builtin,.token.char,.token.inserted,.token.url{color:var(--code-font-color)}.token.attr-name,.token.selector{color:var(--attribute)}.token.attr-value,.token.string{color:var(--string)}.token.operator{color:var(--operator)}.token.atrule,.token.keyword{color:var(--keyword)}.token.function{color:var(--function)}.language-css,.token.boolean,.token.class-name{color:var(--class)!important}.token.regex{color:var(--keyword)}.token.variable{color:var(--variable)}.token.bold{font-weight:700}.token.italic{font-style:italic}.token.entity{cursor:help}.language-jsx .token.class-name{color:var(--tag)!important}code::selection,pre::selection{background:hsla(0,0%,59%,.3)!important;color:inherit;text-shadow:none}code\[class\*=language-\] ::selection,pre\[class\*=language-\]::selection{background:hsla(0,0%,59%,.3)!important;color:inherit;text-shadow:none}React Tutorial: An Overview and Walkthrough | Tania Rascia\[{"@context":"http://schema.org","@type":"WebSite","url":"https://www.taniarascia.com","name":"React Tutorial: An Overview and Walkthrough","alternateName":"React Tutorial: An Overview and Walkthrough"},{"@context":"http://schema.org","@type":"BreadcrumbList","itemListElement":\[{"@type":"ListItem","position":1,"item":{"@id":"https://www.taniarascia.com/getting-started-with-react/","name":"React Tutorial: An Overview and Walkthrough","image":"https://www.taniarascia.com/static/d695fe69198cc4558284e9aec1a4892c/92ab1/react.png"}}\]},{"@context":"http://schema.org","@type":"BlogPosting","url":"https://www.taniarascia.com","name":"React Tutorial: An Overview and Walkthrough","alternateName":"React Tutorial: An Overview and Walkthrough","headline":"React Tutorial: An Overview and Walkthrough","image":{"@type":"ImageObject","url":"https://www.taniarascia.com/static/d695fe69198cc4558284e9aec1a4892c/92ab1/react.png"},"description":"I've been hearing about React since I first started learning JavaScript, but I'll admit I took one look at it and it scared me. I saw what…"}\] .anchor.before { position: absolute; top: 0; left: 0; transform: translateX(-100%); padding-right: 4px; } .anchor.after { display: inline-block; padding-left: 4px; } h1 .anchor svg, h2 .anchor svg, h3 .anchor svg, h4 .anchor svg, h5 .anchor svg, h6 .anchor svg { visibility: hidden; } h1:hover .anchor svg, h2:hover .anchor svg, h3:hover .anchor svg, h4:hover .anchor svg, h5:hover .anchor svg, h6:hover .anchor svg, h1 .anchor:focus svg, h2 .anchor:focus svg, h3 .anchor:focus svg, h4 .anchor:focus svg, h5 .anchor:focus svg, h6 .anchor:focus svg { visibility: visible; } document.addEventListener("DOMContentLoaded", function(event) { var hash = window.decodeURI(location.hash.replace('#', '')) if (hash !== '') { var element = document.getElementById(hash) if (element) { var scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop var clientTop = document.documentElement.clientTop || document.body.clientTop || 0 var offset = element.getBoundingClientRect().top + scrollTop - clientTop // Wait for the browser to finish rendering before scrolling. setTimeout((function() { window.scrollTo(0, offset - 0) }), 0) } } }) 

[![Tania Rascia](/static/floppylogo-0c07fbe46fbceda7efdfb169dd4ef14a.png)Tania Rascia](/)

[Home](/)

[About](/me)

[Blog](/blog)

[Projects](/projects)

[Illustration](/illustration)

![GitHub](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACgAAAAoCAYAAACM/rhtAAAAAXNSR0IArs4c6QAAAlFJREFUWEfVmLtKA0EUhg1iETD2ETtJbATFlHaxtLFSMAHB0sZOsPLSCGkkCj5BougrCNamWBMrQ6JdRDshEawk4pn9zcwwl911i9k0k90zc+afb8+cuaTG9L+hb0oZ6sRhMvZj6txZgSSsXNokOrX6JShhMBAelZ7gx9AP+VcRTJbAp3abRuJ5D1RixMAHe1Ccsh/ZvwzNStAlgcKnDUsmKEFdvUH/k0ydbkeIeZ5gMgViZP8lhPaZqUmlq8gEEyOQi41YYBYKS+RHBhA6BhXo3RKIvPV1dxSLMDhJFw/or0wyNEFnBWIN7jevBXKZxXXhedC6MZLV1Z/4YCuUTBJAsKJo82DiBILE7doyjfzq+Z3Kau1ESdBWP3aCtg5llbb6EQSO+0vdBvVVq7PY6zfZfhAdbs/PClpsBHX1RwKP/dm8QKXnPfr+vyn8uBhMuEBbErw/rAaKTZAb5cOYCDogEBLMn9omVGcPSw5+FDtq9wRqjpfhhO6W9wV4F+dbSpjpIou5fI5lg073RZi1cqNfgokRqPvsNIB8Li+NOFo0jsiJZw+dN56gmwKzjSERWjkrkUDuJsGPFUYu7p+879MSdF4glEPo9E6BXmFfhthDPZzKdIepoHZ532eKQbI5L5AbAcVktsGyT6Y8589eNutwN4ObB/lQFdZuI6m9m3FZIGBK+e8vb5EdpzEFAWpns9vuBXU5j49VtwRWeiwf7s2ob4UrPRaTMdiNN7VcP+KO2lmBEIZve/oqZqS3FnuurLISdrxH7bB2tJP9yPkw5brAHy6QY3VmdklZAAAAAElFTkSuQmCC)[GitHub](https://github.com/taniarascia)

![Theme](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACgAAAAoCAYAAACM/rhtAAAAAXNSR0IArs4c6QAAAYlJREFUWEftmDFuwkAQRe0rRIECWpSWs+QE1ClzDgpKak6QU0TQ0kZROigSixMggbD9LXms4a/HcZhFoVnh3WX/vBnPzpAmHT+jh+R07Sf2hyTtckSnzZeD3QqUwnafiwLUz2s+ZB+jfJzO9jWAbYmaCboXKONKE5y9z2tLQTSUpJlgdAI1wSw2GclfIxidQAhGbFpJ9kYweoEwQOZLGZM3I+hGYFdX907wbgR+bY65Lc/L73xELLoh+C+QFaUsYd+MoCZMppn4Bcp6jlUZzKWh6QXrKMFoBKLqGE+K3sJKMjT2WhP0L3Bd2jQoujSQhKUaUdZEybeWkcN8dZNULvEucLsq+tnHp3o/myhEYWlVMeNB2R9r5MwE3QqUeUsVioUl0SofBhILJdeIwWgFajdGI0bLhegxtH24MTAv6z+5r1EP4m2Gi90JlK7Gdya4LTGWV9UYjEagJCJvireXoQat9hwxFkqMxqB2qnuBjKhmmLUaojHI/Mf+m7a61OxiJriv+T/ri60GnAG1B7A4DYusaQAAAABJRU5ErkJggg==)

![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAYAAACNiR0NAAAACXBIWXMAAAsTAAALEwEAmpwYAAACNUlEQVQ4y41UMU8UURhcjxgKook1CVR2NlZAK7G1soGQ3KxQUBALgvwCDVAQRHItsREsSChUCmMCiQ2JjbEgN8svEBsq9OZMMG933vnukIubTO5788039/bb770s8wMq4kYSBwzUkzjy9WarS3vl6TELhWOg7oR1HviikwvcWL3ZGkhrrjMMGAT1FtQOqA+glku+KHPL5nasGey3w5qT06C2HN8C1QD1ymigKLnMmmnHtX/tLL7CM1BzPX2kkXJz1nb1NsuLVuhRWNw0OQVq0b0L601QL4zN/K/horVlbW59LKol/zwP6iuoFVAfQZ2BemOcmVuxZj6pq5WGyZd9AOo9qNegvvnfQ9HobPEzm23+CppRc1PWBO0715Ze0f0RqCNQ971eAnUMqg5qCNRnY8jcsTWZa47s0fkoB6CGk+2HGTx3vAHq0tgwd25N1A/bo2P4HNRqIgjjcAHqHqjJxHDS3EUcGX+DVXsEw3Y2e3oZ5yr04zGoPVAzoHaTHcQ32HVuz9pQs/Xk9HfW2WEyCqEf26B+eKC/g9oH9dTYN9ewZjv2PXqkgxrn8CGotbxo3/brnYB6aZyUXKGQW7M2rY2GrXTal9L5yqvi0PCDnGWczuvSlZNSHb92Si7Ek2JMgPpiTKD7pCykhr2XQxzwu6AO3fB1UJ9AjeTUiON15w6trQb6musrHsFxz9xMvWpHhWb5O+PceFrT7z7surHzqh218qwWXbfNf93Y6U4Hei6Nvrn4/AGiAH7E5ybSIwAAAABJRU5ErkJggg==)

![](/static/d695fe69198cc4558284e9aec1a4892c/92ab1/react.png)

React Tutorial: An Overview and Walkthrough
===========================================

I've been hearing about React since I first started learning JavaScript, but I'll admit I took one look at it and it scared me. I saw what looked like a bunch of HTML mixed with JavaScript and thought, _isn't this what we've been trying to avoid? What's the big deal with React?_

Instead, I focused on just learning vanilla JavaScript and working with jQuery in a professional setting. After a few frustrated, failed attempts to get started with React, I finally started to get it, and I began to see why I might want to use React instead of vanilla JS or jQuery.

I tried to condense everything I've learned into a nice introduction to share with you, so here it is.

#### [](#prerequisites)Prerequisites

There are a few things you should know in advance before you start playing around with React. If you've never used JavaScript or the DOM at all before, for example, I would get more familiar with those before trying to tackle React.

Here are what I consider to be React prerequisites.

*   Basic familiarity with [HTML & CSS](https://internetingishard.com/).
*   Basic knowledge of [JavaScript](https://www.digitalocean.com/community/tutorial_series/how-to-code-in-javascript) and programming.
*   Basic understanding of [the DOM](/introduction-to-the-dom/).
*   Familiarity with [ES6 syntax and features](/es6-syntax-and-feature-overview/).
*   [Node.js and npm](/how-to-install-and-use-node-js-and-npm-mac-and-windows/) installed globally.

#### [](#goals)Goals

*   Learn about essential React concepts and related terms, such as Babel, Webpack, JSX, components, props, state, and lifecycle.
*   Build a very simple React app that demonstrates the above concepts.

Here's the source and a live demo of the end result.

*   [View Source on GitHub](https://github.com/taniarascia/react-tutorial)
*   [View Demo](https://taniarascia.github.io/react-tutorial/)

[](#what-is-react)What is React?
--------------------------------

*   React is a JavaScript library - one of the most popular ones, with [over 100,000 stars on GitHub](https://github.com/facebook/react).
*   React is not a framework (unlike Angular, which is more opinionated).
*   React is an open-source project created by Facebook.
*   React is used to build user interfaces (UI) on the front end.
*   React is the **view** layer of an MVC application (Model View Controller)

One of the most important aspects of React is the fact that you can create **components**, which are like custom, reusable HTML elements, to quickly and efficiently build user interfaces. React also streamlines how data is stored and handled, using **state** and **props**.

We'll go over all of this and more throughout the article, so let's get started.

[](#setup-and-installation)Setup and Installation
-------------------------------------------------

There are a few ways to set up React, and I'll show you two so you get a good idea of how it works.

### [](#static-html-file)Static HTML File

This first method is not a popular way to set up React and is not how we'll be doing the rest of our tutorial, but it will be familiar and easy to understand if you've ever used a library like jQuery, and it's the least scary way to get started if you're not familiar with Webpack, Babel, and Node.js.

Let's start by making a basic `index.html` file. We're going to load in three CDNs in the `head` - React, React DOM, and Babel. We're also going to make a `div` with an id called `root`, and finally we'll create a `script` tag where your custom code will live.

index.html

    <!DOCTYPE html>
    <html>
      <head>
        <meta charset="utf-8" />
    
        <title>Hello React!</title>
    
        <script src="https://unpkg.com/react@^16/umd/react.production.min.js"></script>
        <script src="https://unpkg.com/react-dom@16.13.0/umd/react-dom.production.min.js"></script>
        <script src="https://unpkg.com/babel-standalone@6.26.0/babel.js"></script>
      </head>
    
      <body>
        <div id="root"></div>
    
        <script type="text/babel">
          // React code will go here
        </script>
      </body>
    </html>

I'm loading in the latest stable versions of the libraries as of the time of this writing.

*   [React](https://reactjs.org/docs/react-api.html) - the React top level API
*   [React DOM](https://reactjs.org/docs/react-dom.html) - adds DOM-specific methods
*   [Babel](https://babeljs.io/) - a JavaScript compiler that lets us use ES6+ in old browsers

The entry point for our app will be the `root` div element, which is named by convention. You'll also notice the `text/babel` script type, which is mandatory for using Babel.

Now, let's write our first code block of React. We're going to use ES6 classes to create a React component called `App`.

index.html

    class App extends React.Component {
      //...
    }

Now we'll add the [`render()`](https://reactjs.org/docs/react-component.html#render) method, the only required method in a class component, which is used to render DOM nodes.

index.html

    class App extends React.Component {
      render() {
          return (
              //...
          );
      }
    }

Inside the `return`, we're going to put what looks like a simple HTML element. Note that we're not returning a string here, so don't use quotes around the element. This is called `JSX`, and we'll learn more about it soon.

index.html

    class App extends React.Component {
      render() {
        return <h1>Hello world!</h1>
      }
    }

Finally, we're going to use the React DOM `render()` method to render the `App` class we created into the `root` div in our HTML.

index.html

    ReactDOM.render(<App />, document.getElementById('root'))

Here is the full code for our `index.html`.

index.html

    <!DOCTYPE html>
    <html>
      <head>
        <meta charset="utf-8" />
    
        <title>Hello React!</title>
    
        <script src="https://unpkg.com/react@16/umd/react.development.js"></script>
        <script src="https://unpkg.com/react-dom@16/umd/react-dom.development.js"></script>
        <script src="https://unpkg.com/babel-standalone@6.26.0/babel.js"></script>
      </head>
    
      <body>
        <div id="root"></div>
    
        <script type="text/babel">
          class App extends React.Component {
            render() {
              return <h1>Hello world!</h1>
            }
          }
    
          ReactDOM.render(<App />, document.getElementById('root'))
        </script>
      </body>
    </html>

Now if you view your `index.html` in the browser, you'll see the `h1` tag we created rendered to the DOM.

Cool! Now that you've done this, you can see that React isn't so insanely scary to get started with. It's just some JavaScript helper libraries that we can load into our HTML.

We've done this for demonstration purposes, but from here out we're going to use another method: Create React App.

### [](#create-react-app)Create React App

The method I just used of loading JavaScript libraries into a static HTML page and rendering the React and Babel on the fly is not very efficient, and is hard to maintain.

Fortunately, Facebook has created [Create React App](https://github.com/facebook/create-react-app), an environment that comes pre-configured with everything you need to build a React app. It will create a live development server, use Webpack to automatically compile React, JSX, and ES6, auto-prefix CSS files, and use ESLint to test and warn about mistakes in the code.

To set up `create-react-app`, run the following code in your terminal, one directory up from where you want the project to live.

    npx create-react-app react-tutorial

Once that finishes installing, move to the newly created directory and start the project.

    cd react-tutorial && npm start

Once you run this command, a new window will popup at `localhost:3000` with your new React app.


> Create React App is very good for getting started for beginners as well as large-scale enterprise applications, but it's not perfect for every workflow. You can also create your own Webpack setup for React.

If you look into the project structure, you'll see a `/public` and `/src` directory, along with the regular `node_modules`, `.gitignore`, `README.md`, and `package.json`.

In `/public`, our important file is `index.html`, which is very similar to the static `index.html` file we made earlier - just a `root` div. This time, no libraries or scripts are being loaded in. The `/src` directory will contain all our React code.

To see how the environment automatically compiles and updates your React code, find the line that looks like this in `/src/App.js`:

    To get started, edit `src/App.js` and save to reload.

And replace it with any other text. Once you save the file, you'll notice `localhost:3000` compiles and refreshes with the new data.

Go ahead and delete all the files out of the `/src` directory, and we'll create our own boilerplate file without any bloat. We'll just keep `index.css` and `index.js`.

For `index.css`, I just copy-and-pasted the contents of [Primitive CSS](https://taniarascia.github.io/primitive/css/main.css) into the file. If you want, you can use Bootstrap or whatever CSS framework you want, or nothing at all. I just find it easier to work with.

Now in `index.js`, we're importing React, ReactDOM, and the CSS file.

src/index.js

    import React from 'react'
    import ReactDOM from 'react-dom'
    import './index.css'

Let's create our `App` component again. Before, we just had an `<h1>`, but now I'm adding in a div element with a class as well. You'll notice that we use `className` instead of `class`. This is our first hint that the code being written here is JavaScript, and not actually HTML.

src/index.js

    class App extends React.Component {
      render() {
        return (
          <div className="App">
            <h1>Hello, React!</h1>
          </div>
        )
      }
    }

Finally, we'll render the `App` to the root as before.

src/index.js

    ReactDOM.render(<App />, document.getElementById('root'))

Here's our full `index.js`. This time, we're loading the `Component` as a property of React, so we no longer need to extend `React.Component`.

src/index.js

    import React, { Component } from 'react'
    import ReactDOM from 'react-dom'
    import './index.css'
    
    class App extends Component {
      render() {
        return (
          <div className="App">
            <h1>Hello, React!</h1>
          </div>
        )
      }
    }
    
    ReactDOM.render(<App />, document.getElementById('root'))

If you go back to `localhost:3000`, you'll see "Hello, React!" just like before. We have the beginnings of a React app now.

### [](#react-developer-tools)React Developer Tools

There is an extension called React Developer Tools that will make your life much easier when working with React. Download [React DevTools for Chrome](https://chrome.google.com/webstore/detail/react-developer-tools/fmkadmapgofadopljbjfkapdkoienihi), or whatever browser you prefer to work on.

After you install it, when you open DevTools, you'll see a tab for React. Click on it, and you'll be able to inspect components as they're written. You can still go to the Elements tab to see the actual DOM output. It may not seem like that much of a deal now, but as the app gets more complicated, it will become increasingly necessary to use.


Now we have all the tools and setup we need to actually begin working with React.

[](#jsx-javascript--xml)JSX: JavaScript + XML
---------------------------------------------

As you've seen, we've been using what looks like HTML in our React code, but it's not quite HTML. This is **JSX**, which stands for JavaScript XML.

With JSX, we can write what looks like HTML, and also we can create and use our own XML-like tags. Here's what JSX looks like assigned to a variable.

JSX

    const heading = <h1 className="site-heading">Hello, React</h1>

Using JSX is not mandatory for writing React. Under the hood, it's running `createElement`, which takes the tag, object containing the properties, and children of the component and renders the same information. The below code will have the same output as the JSX above.

No JSX

    const heading = React.createElement('h1', { className: 'site-heading' }, 'Hello, React!')

JSX is actually closer to JavaScript, not HTML, so there are a few key differences to note when writing it.

*   `className` is used instead of `class` for adding CSS classes, as `class` is a reserved keyword in JavaScript.
*   Properties and methods in JSX are camelCase - `onclick` will become `onClick`.
*   Self-closing tags _must_ end in a slash - e.g. `<img />`

JavaScript expressions can also be embedded inside JSX using curly braces, including variables, functions, and properties.

    const name = 'Tania'
    const heading = <h1>Hello, {name}</h1>

JSX is easier to write and understand than creating and appending many elements in vanilla JavaScript, and is one of the reasons people love React so much.

[](#components)Components
-------------------------

So far, we've created one component - the `App` component. Almost everything in React consists of components, which can be **class components** or **simple components**.

Most React apps have many small components, and everything loads into the main `App` component. Components also often get their own file, so let's change up our project to do so.

Remove the `App` class from `index.js`, so it looks like this.

src/index.js

    import React from 'react'
    import ReactDOM from 'react-dom'
    import App from './App'
    import './index.css'
    
    ReactDOM.render(<App />, document.getElementById('root'))

We'll create a new file called `App.js` and put the component in there.

src/App.js

    import React, { Component } from 'react'
    
    class App extends Component {
      render() {
        return (
          <div className="App">
            <h1>Hello, React!</h1>
          </div>
        )
      }
    }
    
    export default App

We export the component as `App` and load it in `index.js`. It's not mandatory to separate components into files, but an application will start to get unwieldy and out-of-hand if you don't.

### [](#class-components)Class Components

Let's create another component. We're going to create a table. Make `Table.js`, and fill it with the following data.

src/Table.js

    import React, { Component } from 'react'
    
    class Table extends Component {
      render() {
        return (
          <table>
            <thead>
              <tr>
                <th>Name</th>
                <th>Job</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>Charlie</td>
                <td>Janitor</td>
              </tr>
              <tr>
                <td>Mac</td>
                <td>Bouncer</td>
              </tr>
              <tr>
                <td>Dee</td>
                <td>Aspiring actress</td>
              </tr>
              <tr>
                <td>Dennis</td>
                <td>Bartender</td>
              </tr>
            </tbody>
          </table>
        )
      }
    }
    
    export default Table

This component we created is a custom class component. We capitalize custom components to differentiate them from regular HTML elements. Back in `App.js`, we can load in the Table, first by importing it in:

src/App.js

    import Table from './Table'

Then by loading it into the `render()` of `App`, where before we had "Hello, React!". I also changed the class of the outer container.

src/App.js

    import React, { Component } from 'react'
    import Table from './Table'
    
    class App extends Component {
      render() {
        return (
          <div className="container">
            <Table />
          </div>
        )
      }
    }
    
    export default App

If you check back on your live environment, you'll see the `Table` loaded in.


Now we've seen what a custom class component is. We could reuse this component over and over. However, since the data is hard-coded into it, it wouldn't be too useful at the moment.

### [](#simple-components)Simple Components

The other type of component in React is the **simple component**, which is a function. This component doesn't use the `class` keyword. Let's take our `Table` and make two simple components for it - a table header, and a table body.

We're going to use ES6 arrow functions to create these simple components. First, the table header.

src/Table.js

    const TableHeader = () => {
      return (
        <thead>
          <tr>
            <th>Name</th>
            <th>Job</th>
          </tr>
        </thead>
      )
    }

Then the body.

src/Table.js

    const TableBody = () => {
      return (
        <tbody>
          <tr>
            <td>Charlie</td>
            <td>Janitor</td>
          </tr>
          <tr>
            <td>Mac</td>
            <td>Bouncer</td>
          </tr>
          <tr>
            <td>Dee</td>
            <td>Aspiring actress</td>
          </tr>
          <tr>
            <td>Dennis</td>
            <td>Bartender</td>
          </tr>
        </tbody>
      )
    }

Now our `Table` file will look like this. Note that the `TableHeader` and `TableBody` components are all in the same file, and being used by the `Table` class component.

src/Table.js

    const TableHeader = () => { ... }
    const TableBody = () => { ... }
    
    class Table extends Component {
      render() {
        return (
          <table>
            <TableHeader />
            <TableBody />
          </table>
        )
      }
    }

Everything should appear as it did before. As you can see, components can be nested in other components, and simple and class components can be mixed.

> A class component must include `render()`, and the `return` can only return one parent element.

As a wrap up, let's compare a simple component with a class component.

Simple Component

    const SimpleComponent = () => {
      return <div>Example</div>
    }

Class Component

    class ClassComponent extends Component {
      render() {
        return <div>Example</div>
      }
    }

Note that if the `return` is contained to one line, it does not need parentheses.

[](#props)Props
---------------

Right now, we have a cool `Table` component, but the data is being hard-coded. One of the big deals about React is how it handles data, and it does so with properties, referred to as **props**, and with state. Now, we'll focus on handling data with props.

First, let's remove all the data from our `TableBody` component.

src/Table.js

    const TableBody = () => {
      return <tbody />
    }

Then let's move all that data to an array of objects, as if we were bringing in a JSON-based API. We'll have to create this array inside our `render()`.

src/App.js

    class App extends Component {
      render() {
        const characters = [
          {
            name: 'Charlie',
            job: 'Janitor',
          },
          {
            name: 'Mac',
            job: 'Bouncer',
          },
          {
            name: 'Dee',
            job: 'Aspring actress',
          },
          {
            name: 'Dennis',
            job: 'Bartender',
          },
        ]
    
        return (
          <div className="container">
            <Table />
          </div>
        )
      }
    }

Now, we're going to pass the data through to the child component (`Table`) with properties, kind of how you might pass data through using `data-` attributes. We can call the property whatever we want, as long as it's not a reserved keyword, so I'll go with `characterData`. The data I'm passing through is the `characters` variable, and I'll put curly braces around it as it's a JavaScript expression.

src/App.js

    return (
      <div className="container">
        <Table characterData={characters} />
      </div>
    )

Now that data is being passed through to `Table`, we have to work on accessing it from the other side.

src/Table.js

    class Table extends Component {
      render() {
        const { characterData } = this.props
    
        return (
          <table>
            <TableHeader />
            <TableBody characterData={characterData} />
          </table>
        )
      }
    }

If you open up React DevTools and inspect the `Table` component, you'll see the array of data in the property. The data that's stored here is known as the **virtual DOM**, which is a fast and efficient way of syncing data with the actual DOM.



This data is not in the actual DOM yet, though. In `Table`, we can access all props through `this.props`. We're only passing one props through, characterData, so we'll use `this.props.characterData` to retrieve that data.

I'm going to use the ES6 property shorthand to create a variable that contains `this.props.characterData`.

    const { characterData } = this.props

Since our `Table` component actually consists of two smaller simple components, I'm going to pass it through to the `TableBody`, once again through props.

src/Table.js

    class Table extends Component {
      render() {
        const { characterData } = this.props
    
        return (
          <table>
            <TableHeader />
            <TableBody characterData={characterData} />
          </table>
        )
      }
    }

Right now, `TableBody` takes no parameters and returns a single tag.

src/Table.js

    const TableBody = () => {
      return <tbody />
    }

We're going to pass the props through as a parameter, and [map through the array](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/map) to return a table row for each object in the array. This map will be contained in the `rows` variable, which we'll return as an expression.

src/Table.js

    const TableBody = (props) => {
      const rows = props.characterData.map((row, index) => {
        return (
          <tr key={index}>
            <td>{row.name}</td>
            <td>{row.job}</td>
          </tr>
        )
      })
    
      return <tbody>{rows}</tbody>
    }

If you view the front end of the app, all the data is loading in now.

You'll notice I've added a key index to each table row. You should always use [keys](https://reactjs.org/docs/lists-and-keys.html#keys) when making lists in React, as they help identify each list item. We'll also see how this is necessary in a moment when we want to manipulate list items.

Props are an effective way to pass existing data to a React component, however the component cannot change the props - they're read-only. In the next section, we'll learn how to use state to have further control over handling data in React.

[](#state)State
---------------

Right now, we're storing our character data in an array in a variable, and passing it through as props. This is good to start, but imagine if we want to be able to delete an item from the array. With props, we have a one way data flow, but with state we can update private data from a component.

You can think of state as any data that should be saved and modified without necessarily being added to a database - for example, adding and removing items from a shopping cart before confirming your purchase.

To start, we're going to create a `state` object.

src/App.js

    class App extends Component {
      state = {}
    }

The object will contain properties for everything you want to store in the state. For us, it's `characters`.

src/App.js

    class App extends Component {
      state = {
        characters: [],
      }
    }

Move the entire array of objects we created earlier into `state.characters`.

src/App.js

    class App extends Component {
      state = {
        characters: [
          {
            name: 'Charlie',
            // the rest of the data
          },
        ],
      }
    }

Our data is officially contained in the state. Since we want to be able to remove a character from the table, we're going to create a `removeCharacter` method on the parent `App` class.

To retrieve the state, we'll get `this.state.characters` using the same ES6 method as before. To update the state, we'll use `this.setState()`, a built-in method for manipulating state. We'll [filter the array](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/filter) based on an `index` that we pass through, and return the new array.

> You must use `this.setState()` to modify an array. Simply applying a new value to `this.state.property` will not work.

src/App.js

    removeCharacter = (index) => {
      const { characters } = this.state
    
      this.setState({
        characters: characters.filter((character, i) => {
          return i !== index
        }),
      })
    }

`filter` does not mutate but rather creates a new array, and is a preferred method for modifying arrays in JavaScript. This particular method is testing an index vs. all the indices in the array, and returning all but the one that is passed through.

Now we have to pass that function through to the component, and render a button next to each character that can invoke the function. We'll pass the `removeCharacter` function through as a prop to `Table`.

src/App.js

    render() {
      const { characters } = this.state
    
      return (
        <div className="container">
          <Table characterData={characters} removeCharacter={this.removeCharacter} />
        </div>
      )
    }

Since we're passing it down to `TableBody` from `Table`, we're going to have to pass it through again as a prop, just like we did with the character data.

In addition, since it turns out that the only components having their own states in our project are `App` and `Form`, it would be best practice to transform `Table` into a simple component from the class component it currently is.

src/Table.js

    const Table = (props) => {
      const { characterData, removeCharacter } = props
    
      return (
        <table>
          <TableHeader />
          <TableBody characterData={characterData} removeCharacter={removeCharacter} />
        </table>
      )
    }

Here's where that index we defined in the `removeCharacter()` method comes in. In the `TableBody` component, we'll pass the key/index through as a parameter, so the filter function knows which item to remove. We'll create a button with an `onClick` and pass it through.

src/Table.js

    <tr key={index}>
      <td>{row.name}</td>
      <td>{row.job}</td>
      <td>
        <button onClick={() => props.removeCharacter(index)}>Delete</button>
      </td>
    </tr>

> The `onClick` function must pass through a function that returns the `removeCharacter()` method, otherwise it will try to run automatically.

Awesome. Now we have delete buttons, and we can modify our state by deleting a character.


I deleted Mac.

Now you should understand how state gets initialized and how it can be modified.

[](#submitting-form-data)Submitting Form Data
---------------------------------------------

Now we have data stored in state, and we can remove any item from the state. However, what if we wanted to be able to add new data to state? In a real world application, you'd more likely start with empty state and add to it, such as with a to-do list or a shopping cart.

Before anything else, let's remove all the hard-coded data from `state.characters`, as we'll be updating that through the form now.

src/App.js

    class App extends Component {
      state = {
        characters: [],
      }
    }

Now let's go ahead and create a `Form` component in a new file called `Form.js`.

We're going to set the initial state of the `Form` to be an object with some empty properties, and assign that initial state to `this.state`.

src/Form.js

    import React, { Component } from 'react'
    
    class Form extends Component {
      initialState = {
        name: '',
        job: '',
      }
    
      state = this.initialState
    }

> Previously, it was necessary to include a `constructor()` on React class components, but it's not required anymore.

Our goal for this form will be to update the state of `Form` every time a field is changed in the form, and when we submit, all that data will pass to the `App` state, which will then update the `Table`.

First, we'll make the function that will run every time a change is made to an input. The `event` will be passed through, and we'll set the state of `Form` to have the `name` (key) and `value` of the inputs.

src/Form.js

    handleChange = (event) => {
      const { name, value } = event.target
    
      this.setState({
        [name]: value,
      })
    }

Let's get this working before we move on to submitting the form. In the render, let's get our two properties from state, and assign them as the values that correspond to the proper form keys. We'll run the `handleChange()` method as the `onChange` of the input, and finally we'll export the `Form` component.

src/Form.js

    render() {
      const { name, job } = this.state;
    
      return (
        <form>
          <label htmlFor="name">Name</label>
          <input
            type="text"
            name="name"
            id="name"
            value={name}
            onChange={this.handleChange} />
          <label htmlFor="job">Job</label>
          <input
            type="text"
            name="job"
            id="job"
            value={job}
            onChange={this.handleChange} />
        </form>
      );
    }
    
    export default Form;

In `App.js`, we can render the form below the table.

src/App.js

    import Form from './Form'

src/App.js

    return (
      <div className="container">
        <Table characterData={characters} removeCharacter={this.removeCharacter} />
        <Form />
      </div>
    )

Now if we go to the front end of our app, we'll see a form that doesn't have a submit yet. Update some fields and you'll see the local state of `Form` being updated.


Cool. Last step is to allow us to actually submit that data and update the parent state. We'll create a function called `handleSubmit()` on `App` that will update the state by taking the existing `this.state.characters` and adding the new `character` parameter, using the [ES6 spread operator](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Spread_syntax).

src/App.js

    handleSubmit = (character) => {
      this.setState({ characters: [...this.state.characters, character] })
    }

Let's make sure we pass that through as a parameter on `Form`.

    <Form handleSubmit={this.handleSubmit} />

Now in `Form`, we'll create a method called `submitForm()` that will call that function, and pass the `Form` state through as the `character` parameter we defined earlier. It will also reset the state to the initial state, to clear the form after submit.

src/Form.js

    submitForm = () => {
      this.props.handleSubmit(this.state)
      this.setState(this.initialState)
    }

Finally, we'll add a submit button to submit the form. We're using an `onClick` instead of an `onSubmit` since we're not using the standard submit functionality. The click will call the `submitForm` we just made.

    <input type="button" value="Submit" onClick={this.submitForm} />

And that's it! The app is complete. We can create, add, and remove users from our table. Since the `Table` and `TableBody` were already pulling from the state, it will display properly.


If you got lost anywhere along the way, you can view [the complete source on GitHub](https://github.com/taniarascia/react-tutorial).

[](#pulling-in-api-data)Pulling in API Data
-------------------------------------------

One very common usage of React is pulling in data from an API. If you're not familiar with what an API is or how to connect to one, I would recommend reading [How to Connect to an API with JavaScript](/how-to-connect-to-an-api-with-javascript/), which will walk you through what APIs are and how to use them with vanilla JavaScript.

As a little test, we can create a new `Api.js` file, and create a new `App` in there. A public API we can test with is the [Wikipedia API](https://en.wikipedia.org/w/api.php), and I have a [URL endpoint right here](https://en.wikipedia.org/w/api.php?action=opensearch&search=Seona+Dancing&format=json&origin=*) for a random\* search. You can go to that link to see the API - and make sure you have [JSONView](https://chrome.google.com/webstore/detail/jsonview/chklaanhfefbnpoihckbnefhakgolnmc) installed on your browser.

We're going to use [JavaScript's built-in Fetch](/how-to-use-the-javascript-fetch-api-to-get-json-data/) to gather the data from that URL endpoint and display it. You can switch between the app we created and this test file by just changing the URL in `index.js` - `import App from './Api';`.

I'm not going to explain this code line-by-line, as we've already learned about creating a component, rendering, and mapping through a state array. The new aspect to this code is `componentDidMount()`, a React lifecycle method. **Lifecycle** is the order in which methods are called in React. **Mounting** refers to an item being inserted into the DOM.

When we pull in API data, we want to use `componentDidMount`, because we want to make sure the component has rendered to the DOM before we bring in the data. In the below snippet, you'll see how we bring in data from the Wikipedia API, and display it on the page

Api.js

    import React, { Component } from 'react'
    
    class App extends Component {
      state = {
        data: [],
      }
    
      // Code is invoked after the component is mounted/inserted into the DOM tree.
      componentDidMount() {
        const url =
          'https://en.wikipedia.org/w/api.php?action=opensearch&search=Seona+Dancing&format=json&origin=*'
    
        fetch(url)
          .then((result) => result.json())
          .then((result) => {
            this.setState({
              data: result,
            })
          })
      }
    
      render() {
        const { data } = this.state
    
        const result = data.map((entry, index) => {
          return <li key={index}>{entry}</li>
        })
    
        return <ul>{result}</ul>
      }
    }
    
    export default App

Once you save and run this file in the local server, you'll see the Wikipedia API data displayed in the DOM.


There are other lifecycle methods, but going over them will be beyond the scope of this article. You can [read more about React components here](https://reactjs.org/docs/react-component.html).

_\*Wikipedia search choice may not be random. It might be an article that I spearheaded back in 2005._

[](#building-and-deploying-a-react-app)Building and Deploying a React App
-------------------------------------------------------------------------

Everything we've done so far has been in a development environment. We've been compiling, hot-reloading, and updating on the fly. For production, we're going to want to have static files loading in - none of the source code. We can do this by making a build and deploying it.

Now, if you just want to compile all the React code and place it in the root of a directory somewhere, all you need to do is run the following line:

    npm run build

This will create a `build` folder which will contain your app. Put the contents of that folder anywhere, and you're done!

We can also take it a step further, and have npm deploy for us. We're going to build to GitHub pages, so you'll already have to [be familiar with Git](/getting-started-with-git/) and getting your code up on GitHub.

Make sure you've exited out of your local React environment, so the code isn't currently running. First, we're going to add a `homepage` field to `package.json`, that has the URL we want our app to live on.

package.json

    "homepage": "https://taniarascia.github.io/react-tutorial",

We'll also add these two lines to the `scripts` property.

    "scripts": {
      // ...
      "predeploy": "npm run build",
      "deploy": "gh-pages -d build"
    }

In your project, you'll add `gh-pages` to the devDependencies.

    npm install --save-dev gh-pages

We'll create the `build`, which will have all the compiled, static files.

    npm run build

Finally, we'll deploy to `gh-pages`.

    npm run deploy

