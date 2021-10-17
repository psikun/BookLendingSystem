import { createStore } from "vuex";

export default createStore({
  state: {
    opened: true,
  },
  mutations: {
    openAside(state) {
      state.opened = !state.opened;
    },
  },
  actions: {},
  modules: {},
});
