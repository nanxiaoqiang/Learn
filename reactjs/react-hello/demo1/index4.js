var MyComponentAjaxGetGitHubAccount = React.createClass({
  getInitialState: function() {
    return {
      loading: true,
      error: null,
      data: null
    };
  },
  componentDidMount: function() {
    this.props.promise.then(// 当value||error有值的时候赋值setState
      value => this.setState({loading: false, data: value}),
      error => this.setState({loading: false, error: error}));
  },
  render: function() {
    if (this.state.loading) {
      return <span>Loading...</span>;
    } else if (this.state.error !== null) {
      return <span>Error: {this.state.error.message}</span>;
    } else {
      var repos = this.state.data.items;
      var repoList = repos.map(function (repo) {
        console.log(repo.id);
        return (
          <li key={repo.id}>{/* 加key用于保证DOM对象的唯一性，类似于backbone里使用的id */}
            <a href={repo.html_url}>{repo.name}</a> ({repo.stargazers_count} stars) <br/> {repo.description}
          </li>
        );
      });
      return (
        <main>
          <h1>Most Popular JavaScript Projects in Github</h1>
          <ol>{repoList}</ol>
        </main>
      );
    }
  }
});

ReactDOM.render(
  <MyComponentAjaxGetGitHubAccount promise={$.getJSON('https://api.github.com/search/repositories?q=javascript&sort=stars')} />,
  document.getElementById('content')
);
