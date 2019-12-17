package com.nv.tech.retrofit2.example;

import java.io.IOException;
import java.util.List;

import com.nv.tech.retrofit2.example.dto.Repo;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StartRetrofit2 {

	public static void main(String[] args) throws IOException {

		Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("https://api.github.com/")
			.addConverterFactory(GsonConverterFactory.create())
			.build();

		GitHubService service = retrofit.create(GitHubService.class);

		Call<List<Repo>> repos = service
			.listRepos("lukechi1219", "test"); // , "aa123"

		Response<List<Repo>> response = repos.execute();

		if (response.isSuccessful()) {
			List<Repo> list = response.body();
			if (list != null) {
				System.out.println(list.size());
				System.out.println(list.get(0).getName());
				System.out.println("----");
				System.out.println(list.get(0).toString());
			}
		}
	}
}

/*
{id=2.28387061E8, node_id=MDEwOlJlcG9zaXRvcnkyMjgzODcwNjE=, name=2020TechReviewDart, full_name=lukechi1219/2020TechReviewDart, private=false,

owner=
{login=lukechi1219, id=6668710.0, node_id=MDQ6VXNlcjY2Njg3MTA=,
avatar_url=https://avatars3.githubusercontent.com/u/6668710?v=4, gravatar_id=,
url=https://api.github.com/users/lukechi1219, html_url=https://github.com/lukechi1219, followers_url=https://api.github.com/users/lukechi1219/followers,
following_url=https://api.github.com/users/lukechi1219/following{/other_user}, gists_url=https://api.github.com/users/lukechi1219/gists{/gist_id},
starred_url=https://api.github.com/users/lukechi1219/starred{/owner}{/repo}, subscriptions_url=https://api.github.com/users/lukechi1219/subscriptions,
organizations_url=https://api.github.com/users/lukechi1219/orgs, repos_url=https://api.github.com/users/lukechi1219/repos,
events_url=https://api.github.com/users/lukechi1219/events{/privacy}, received_events_url=https://api.github.com/users/lukechi1219/received_events, type=User, site_admin=false},

html_url=https://github.com/lukechi1219/2020TechReviewDart, description=null, fork=false,
url=https://api.github.com/repos/lukechi1219/2020TechReviewDart,
forks_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/forks,
keys_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/keys{/key_id},
collaborators_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/collaborators{/collaborator},
teams_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/teams, hooks_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/hooks,
issue_events_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/issues/events{/number},
events_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/events,
assignees_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/assignees{/user},
branches_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/branches{/branch},
tags_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/tags,
blobs_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/git/blobs{/sha},
git_tags_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/git/tags{/sha},
git_refs_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/git/refs{/sha},
trees_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/git/trees{/sha},
statuses_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/statuses/{sha},
languages_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/languages,
stargazers_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/stargazers,
contributors_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/contributors,
subscribers_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/subscribers,
subscription_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/subscription,
commits_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/commits{/sha},
git_commits_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/git/commits{/sha},
comments_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/comments{/number},
issue_comment_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/issues/comments{/number},
contents_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/contents/{+path},
compare_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/compare/{base}...{head},
merges_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/merges,
archive_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/{archive_format}{/ref},
downloads_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/downloads,
issues_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/issues{/number},
pulls_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/pulls{/number},
milestones_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/milestones{/number},
notifications_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/notifications{?since,all,participating},
labels_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/labels{/name},
releases_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/releases{/id},
deployments_url=https://api.github.com/repos/lukechi1219/2020TechReviewDart/deployments,
created_at=2019-12-16T12:53:55Z, updated_at=2019-12-16T14:09:42Z, pushed_at=2019-12-16T12:54:09Z,
git_url=git://github.com/lukechi1219/2020TechReviewDart.git, ssh_url=git@github.com:lukechi1219/2020TechReviewDart.git,
clone_url=https://github.com/lukechi1219/2020TechReviewDart.git, svn_url=https://github.com/lukechi1219/2020TechReviewDart,
homepage=null, size=1.0, stargazers_count=0.0, watchers_count=0.0, language=null, has_issues=true, has_projects=true, has_downloads=true, has_wiki=true,
has_pages=false, forks_count=0.0, mirror_url=null, archived=false, disabled=false, open_issues_count=0.0, license=null, forks=0.0, open_issues=0.0,
watchers=0.0,
default_branch=master}

Process finished with exit code 0

 */