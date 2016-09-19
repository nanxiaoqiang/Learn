var MyComponentAjaxGetGitHubAccount = React.createClass({
  getInitialState: function() {
    return {
      _data: {
        login: '',// 登录名
        id: void 0,// id
        html_url: '',// 主页地址
        type: '',// 账户类型
        name: '',// 用户名
        company: '',// 公司
        blog: '',// 主页
        location: '',// 地址
        email: '',// email
        bio: '',// 自我介绍
        public_repos: 0,
        public_gists: 0,
        followers: 0,
        following: 0,
        created_at: '',
        updated_at: ''

      }

    };
  },
  componentDidMount: function() {
    $.get(this.props.ajax_url, function(result){
      console.log(!!result);
      console.log(result);
      if(!!result) {
        this.setState({_data: result});
      } else {
        console.log('调用失败啦！');
      }
    }.bind(this));
  },
  render: function() {
    var __data = this.state._data;
    console.log(__data);
    return (
      <ul>
        <li>登录名:{__data.login}</li>
        <li>id:{__data.id}</li>
        <li>主页地址:{__data.html_url}</li>
        <li>账户类型:{__data.type}</li>
        <li>用户名:{__data.name}</li>
        <li>公司:{__data.company}</li>
        <li>主页:{__data.blog}</li>
        <li>地址:{__data.location}</li>
        <li>email:{__data.email}</li>
        <li>自我介绍:{__data.bio == void 0 ? '这家伙很懒，什么都没留下' : __data.bio}</li>
        <li>Repos:{__data.public_repos}</li>
        <li>Gists:{__data.public_gists}</li>
        <li>followers:{__data.followers}</li>
        <li>following:{__data.following}</li>
        <li>注册时间:{__data.created_at}</li>
        <li>最近更新:{__data.updated_at}</li>
      </ul>
    );
  }
});

ReactDOM.render(
  <MyComponentAjaxGetGitHubAccount ajax_url='https://api.github.com/users/nanxiaoqiang' />,
  document.getElementById('content')
);
