package yaus

class StatsController {

    def index() {
        def criteria = Visit.createCriteria()
        def visits = criteria.list(params) {
            projections {
                groupProperty('link')
                rowCount('visitCount')
            }
            if (!params.order)
                order('visitCount','desc')
        }
        [visits: visits]
    }
}
