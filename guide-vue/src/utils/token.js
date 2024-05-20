// 返回token
export const getToken = () => {
  const token = localStorage.getItem("token");
  return token;
};

// 将token存储到localStorage中
export const setToken = (token) => {
  localStorage.setItem("token", token);
};

// 从localStorage中移除token
export const removeToken = () => {
  localStorage.removeItem("token");
};
