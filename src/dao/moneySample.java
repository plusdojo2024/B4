package dao;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AmountUseds;
import model.Costs;
import model.CurrentSavings;
import model.Incomes;
import model.TargetSavings;
	/**
	 * Servlet implementation class MoneyThinkServlet
	 */
	@WebServlet("/MoneySampleServlet")
	public class moneySample extends HttpServlet {
		private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			AmountUsedsDao ADao = new AmountUsedsDao();
			LocalDate today = LocalDate.now();
			List<AmountUseds> al  =ADao.allList();

			int aSum = 0;
			for(AmountUseds au: al) {
				aSum = aSum + au.getAmount_used();
			}

			int sum = ADao.calcList(al);
			List<Integer> yearList = ADao.yearList(al,2024);
			List<Integer> weekList = ADao.weekList(al);
			List<Integer> dayList = ADao.dayList(al,today);
			request.setAttribute("yearList", yearList);
			request.setAttribute("weekList", weekList);
			request.setAttribute("dayList", dayList);
			request.setAttribute("sum", sum);


			CostsDao cDao = new CostsDao();
			List<Costs> costList = cDao.allList();
			request.setAttribute("cost", costList);
			int cSum = 0;
			for(Costs c: costList) {
				cSum = cSum +c.getFixed_money();
			}
			request.setAttribute("cSum", cSum);


			IncomesDao iDao = new IncomesDao();
			List<Incomes> incomeList = iDao.allList();
			int income = 0;
			for(Incomes i:incomeList) {
				income = i.getIncome();
			}
			request.setAttribute("income", income);

			CurrentSavingsDao sDao = new CurrentSavingsDao();
			List<CurrentSavings> CurrentSavingsList = sDao.allList();
			int CurrentSavings = 0;
			for(CurrentSavings i:CurrentSavingsList) {
				CurrentSavings = i.getCurrent_saving();
			}
			request.setAttribute("CurrentSavings", CurrentSavings);

			TargetSavingDao tDao = new TargetSavingDao();
			List<TargetSavings> TargetSavingsList = tDao.allList();
			int TargetSavings = 0;
			int target =0;
			int period =0;
			for(TargetSavings i:TargetSavingsList) {
				TargetSavings =  i.getTarget_saving();
				period = i.getPeriod();
				if(i.getSaving_period().equals("月")) {
					target = TargetSavings / period * 30;
				}else {
					target = TargetSavings / period * 7;
				}
			}
			request.setAttribute("TargetSavingSavings", TargetSavingsList);


			 int yosan =  target- income - cSum - - aSum;
			 request.setAttribute("yosan", yosan);


			// 予算逆算ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/moneySample.jsp");
			dispatcher.forward(request, response);

		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			AmountUsedsDao ADao = new AmountUsedsDao();
			LocalDate today = LocalDate.now();
			List<AmountUseds> al  =ADao.allList();

			int aSum = 0;
			for(AmountUseds au: al) {
				aSum = aSum + au.getAmount_used();
			}

			int sum = ADao.calcList(al);
			List<Integer> yearList = ADao.yearList(al,2024);
			List<Integer> weekList = ADao.weekList(al);
			List<Integer> dayList = ADao.dayList(al,today);
			request.setAttribute("yearList", yearList);
			request.setAttribute("weekList", weekList);
			request.setAttribute("dayList", dayList);
			request.setAttribute("sum", sum);


			CostsDao cDao = new CostsDao();
			List<Costs> costList = cDao.allList();
			request.setAttribute("cost", costList);
			int cSum = 0;
			for(Costs c: costList) {
				cSum = cSum +c.getFixed_money();
			}
			request.setAttribute("cSum", cSum);


			IncomesDao iDao = new IncomesDao();
			List<Incomes> incomeList = iDao.allList();
			int income = 0;
			for(Incomes i:incomeList) {
				income = i.getIncome();
			}
			request.setAttribute("income", income);

			CurrentSavingsDao sDao = new CurrentSavingsDao();
			List<CurrentSavings> CurrentSavingsList = sDao.allList();
			int CurrentSavings = 0;
			for(CurrentSavings i:CurrentSavingsList) {
				CurrentSavings = i.getCurrent_saving();
			}
			request.setAttribute("CurrentSavings", CurrentSavings);

			TargetSavingDao tDao = new TargetSavingDao();
			List<TargetSavings> TargetSavingsList = tDao.allList();
			int TargetSavings = 0;
			int target =0;
			int period =0;
			for(TargetSavings i:TargetSavingsList) {
				TargetSavings =  i.getTarget_saving();
				period = i.getPeriod();
				if(i.getSaving_period().equals("月")) {
					target = TargetSavings / period * 30;
				}else {
					target = TargetSavings / period * 7;
				}
			}
			request.setAttribute("TargetSavingSavings", TargetSavingsList);


			 int yosan =  target- income - cSum - - aSum;
			 request.setAttribute("yosan", yosan);

				//moneyThink.jspを開く
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/moneySample.jsp");
				dispatcher.forward(request, response);

			}
		}
